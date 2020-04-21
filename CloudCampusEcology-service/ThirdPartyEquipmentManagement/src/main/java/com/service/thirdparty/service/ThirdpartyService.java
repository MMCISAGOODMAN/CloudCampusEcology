package com.service.thirdparty.service;

import com.service.thirdparty.model.ThirdpartyDevice;
import com.service.thirdparty.model.ThirdpartyDevicelog;

import java.util.List;

/**
 * @ClassName ThirdPartyService
 * @Description 第三方设备纳管service
 * @Author mamingcong
 * @Date 2020/4/21 14:46
 * @Version 1.0
 */
public interface ThirdpartyService {
    void addDevice(ThirdpartyDevice thirdpartyDevice);

    void editDevice(ThirdpartyDevice thirdpartyDevice);

    void delDevice(String id);

    List<ThirdpartyDevicelog> getDeviceStatusList();

    List<ThirdpartyDevicelog> getDeviceStatusDetailList(String deviceId);
}
