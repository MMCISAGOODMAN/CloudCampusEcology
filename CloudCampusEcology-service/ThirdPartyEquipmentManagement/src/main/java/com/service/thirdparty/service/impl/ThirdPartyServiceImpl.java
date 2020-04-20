package com.service.thirdparty.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.thirdparty.service.BaseService;
import com.service.thirdparty.service.ThirdPartyService;
import com.service.thirdparty.utils.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName ThirdPartyServiceImpl
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/17 14:00
 * @Version 1.0
 */
@Service
public class ThirdPartyServiceImpl implements ThirdPartyService , BaseService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String getFeign() {
        return "未进行远程调用";
    }

    @Override
    public Object getDeviceList() {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        requestHeaders.add("Accept", "application/json");
        //获取token
        String token = getToken(USERNAME, PASSWORD, requestHeaders);
        //获取站点
        requestHeaders.add("X-AUTH-TOKEN", token);
     //   List<String> sites = getSites(requestHeaders);
        //获取维护的设备当前信息
        return getDeviceDetail(requestHeaders);
    }

    private Object getDeviceDetail(HttpHeaders requestHeaders) {
        Map map = new HashMap();
        HttpEntity<Map> requestEntity = new HttpEntity<Map>(map, requestHeaders);
        ResponseEntity<JSONObject> response = restTemplate.exchange(DEVICE_DETAIL_URL, HttpMethod.GET, requestEntity, JSONObject.class);
        return  response.getBody().getJSONArray("data");
    }

    private String getToken(String username, String password, HttpHeaders requestHeaders) {
        Map map = new HashMap();
        map.put("userName", username);
        map.put("password", password);
        HttpEntity<Map> requestEntity = new HttpEntity<Map>(map, requestHeaders);
        ResponseEntity<JSONObject> response = restTemplate.exchange(TOKEN_URL, HttpMethod.POST, requestEntity, JSONObject.class);
        return response.getBody().getJSONObject("data").getString("token_id");
    }

//    private List<String> getSites(HttpHeaders requestHeaders) {
//        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
//        ResponseEntity<JSONObject> response = restTemplate.exchange(SITE_URL, HttpMethod.GET, requestEntity, JSONObject.class);
//        JSONArray data = response.getBody().getJSONArray("data");
//        List list = new ArrayList();
//        for (int i = 0; i < data.size(); i++) {
//            String id = data.getJSONObject(i).getString("id");
//            list.add(id);
//        }
//        return list;
//    }

}
