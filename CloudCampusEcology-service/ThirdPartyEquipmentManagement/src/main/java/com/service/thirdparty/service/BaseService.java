package com.service.thirdparty.service;

/**
 * @ClassName BaseService
 * @Description 基础配置类
 * @Author mamingcong
 * @Date 2020/4/14 14:26
 * @Version 1.0
 */
public interface BaseService {

    //获取token
    String TOKEN_URL="https://naas3.huaweicloud.com:18002/controller/v2/tokens";
    //获取站点
    String SITE_URL="https://naas3.huaweicloud.com:18002/controller/campus/v3/sites?pageIndex=1&pageSize=20";

    String USERNAME="wangwg@huawei.com";

    String PASSWORD="Api@YGL#20200330";
    //获取日志
    String LOGURL="https://naas3.huaweicloud.com:18002/controller/campus/v1/oamservice/devicelog?";

    //获取设备信息
    String DEVICE_DETAIL_URL="https://naas3.huaweicloud.com:18002/rest/openapi/network/nedevice?";
}
