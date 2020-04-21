package com.service.thirdparty.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.thirdparty.mapper.ThirdpartyDeviceMapper;
import com.service.thirdparty.mapper.ThirdpartyDevicelogMapper;
import com.service.thirdparty.model.ThirdpartyDevice;
import com.service.thirdparty.model.ThirdpartyDevicelog;
import com.service.thirdparty.model.ThirdpartyDevicelogExample;
import com.service.thirdparty.service.BaseService;
import com.service.thirdparty.service.ThirdpartyService;
import com.service.thirdparty.utils.IdUtil;
import com.service.thirdparty.utils.RedisUtils;
import com.service.thirdparty.utils.StringUtils;
import demo.common.enums.DeleteFlag;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName ThirdPartyServiceImpl
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/21 14:46
 * @Version 1.0
 */
@Service
@Transactional
public class ThirdpartyServiceImpl implements ThirdpartyService, BaseService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private ThirdpartyDeviceMapper thirdpartyDeviceMapper;

    @Resource
    private ThirdpartyDevicelogMapper thirdpartyDevicelogMapper;

    @Override
    public void addDevice(ThirdpartyDevice thirdpartyDevice) {
        thirdpartyDevice.setId(IdUtil.getStringId());
        thirdpartyDevice.setDeleteFlag(DeleteFlag.ON.getCode());
        thirdpartyDevice.setCreateTime(new Date());
        thirdpartyDeviceMapper.insert(thirdpartyDevice);
    }

    @Override
    public void editDevice(ThirdpartyDevice thirdpartyDevice) {
        //TODO 修改设备的日志信息
        thirdpartyDeviceMapper.updateByPrimaryKeySelective(thirdpartyDevice);
    }

    @Override
    public void delDevice(String id) {
        ThirdpartyDevice thirdpartyDevice = new ThirdpartyDevice();
        thirdpartyDevice.setId(id);
        thirdpartyDevice.setDeleteFlag(DeleteFlag.OFF.getCode());
        thirdpartyDevice.setDeleteTime(new Date());
        thirdpartyDeviceMapper.updateByPrimaryKeySelective(thirdpartyDevice);
        //删除日志
        ThirdpartyDevicelog thirdpartyDevicelog = new ThirdpartyDevicelog();
        thirdpartyDevicelog.setDeleteFlag(DeleteFlag.OFF.getCode());
        thirdpartyDevicelog.setDeleteTime(new Date());
        ThirdpartyDevicelogExample example = new ThirdpartyDevicelogExample();
        example.createCriteria().andDeviceIdEqualTo(id);
        thirdpartyDevicelogMapper.updateByExampleSelective(thirdpartyDevicelog, example);
    }

    @Override
    public List<ThirdpartyDevicelog> getDeviceStatusList() {
        //时间是否在5分钟之内
        Boolean result = judgeIfInFive();
        //时间在 直接返回
        if (result) {
            return thirdpartyDevicelogMapper.selectByExample(null);
        }
        //时间不在,调用云平台
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        requestHeaders.add("Accept", "application/json");
        //获取token
        String token = getToken(USERNAME, PASSWORD, requestHeaders);
        //获取站点
        requestHeaders.add("X-AUTH-TOKEN", token);
        List<String> sites = getSites(requestHeaders);
        if (StringUtils.isEmpty(sites)) {
            return Collections.emptyList();
        }
        //查询站点下用户登录日志
        List list = new ArrayList();
        for (String site : sites) {
            List<JSONObject> logList = getLogList(site, requestHeaders);
            list.addAll(logList);
        }
        //TODO 分析数据，存入数据库，返回数据，记录查询时间

        return null;
    }

    private Boolean judgeIfInFive() {
        String queryTime = redisUtils.get("queryTime");
        long currentTime = System.currentTimeMillis();
        if (StringUtils.isEmpty(queryTime)) {
            redisUtils.set("queryTime", currentTime);
            return true;
        }
        long preTime = Long.valueOf(queryTime);
        long value = currentTime - preTime;
        long minute = value / (1000 * 60);
        if (minute < 5) {
            return true;
        }
        redisUtils.set("queryTime", currentTime);
        return false;
    }

    @Override
    public List<ThirdpartyDevicelog> getDeviceStatusDetailList(String deviceId) {
        ThirdpartyDevicelogExample example = new ThirdpartyDevicelogExample();
        example.createCriteria().andDeviceIdEqualTo(deviceId)
                .andDeleteFlagEqualTo(DeleteFlag.ON.getCode());
        return thirdpartyDevicelogMapper.selectByExample(example);
    }


    private String getToken(String username, String password, HttpHeaders requestHeaders) {
        Map map = new HashMap();
        map.put("userName", username);
        map.put("password", password);
        HttpEntity<Map> requestEntity = new HttpEntity<Map>(map, requestHeaders);
        ResponseEntity<JSONObject> response = restTemplate.exchange(TOKEN_URL, HttpMethod.POST, requestEntity, JSONObject.class);
        return response.getBody().getJSONObject("data").getString("token_id");
    }

    private List<String> getSites(HttpHeaders requestHeaders) {
        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<JSONObject> response = restTemplate.exchange(SITE_URL, HttpMethod.GET, requestEntity, JSONObject.class);
        JSONArray data = response.getBody().getJSONArray("data");
        List list = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            String id = data.getJSONObject(i).getString("id");
            list.add(id);
        }
        return list;
    }

    private List<JSONObject> getLogList(String site, HttpHeaders requestHeaders) {
        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
        //站点下所有的登录信息
        Boolean flag = true;
        String nextRowkey = "";
        String startRowkey = "";
        String url = null;
        List<JSONObject> jsonObjectList = new ArrayList<>();
        while (flag) {
            url = LOGURL + "pageSize=20&siteId=" + site
                    + "&beginTime=1586793600&endTime=1586847600&sceneName=1&startQueryRowKey=" + startRowkey;
            ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JSONObject.class);
            JSONObject data = response.getBody().getJSONObject("data");
            jsonObjectList.add(data);
            nextRowkey = data.getString("nextRowkey");
            if (StringUtils.isEmpty(nextRowkey)) {
                flag = false;
            } else {
                startRowkey = nextRowkey;
            }
        }
        return jsonObjectList;
    }
}
