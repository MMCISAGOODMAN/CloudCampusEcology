package com.service.thirdparty.service;

/**
 * @ClassName ThirdPartyService
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/17 13:59
 * @Version 1.0
 */
//@FeignClient("network-liuliang")
public interface DemoService {
    //@GetMapping("/liuliang/getFeign")
    String getFeign();

    Object getDeviceList();
}
