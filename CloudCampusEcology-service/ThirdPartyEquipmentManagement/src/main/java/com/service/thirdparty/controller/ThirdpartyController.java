package com.service.thirdparty.controller;

import com.service.thirdparty.model.ThirdpartyDevice;
import com.service.thirdparty.service.ThirdpartyService;
import com.service.thirdparty.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName ThirdpartyController
 * @Description 第三方设备纳管控制器
 * @Author mamingcong
 * @Date 2020/4/21 14:39
 * @Version 1.0
 */
@Api("第三方设备纳管控制器")
@RestController
@RequestMapping("/thirdparty")
public class ThirdpartyController {

    @Resource
    private ThirdpartyService thirdpartyService;

    @ApiOperation(value = "新增设备")
    @PostMapping(value = "/addDevice")
    public Result addDevice(@RequestBody ThirdpartyDevice thirdpartyDevice) {
        thirdpartyService.addDevice(thirdpartyDevice);
        return Result.ok();
    }

    @ApiOperation(value = "修改设备")
    @PostMapping(value = "/editDevice")
    public Result editDevice(@RequestBody ThirdpartyDevice thirdpartyDevice) {
        thirdpartyService.editDevice(thirdpartyDevice);
        return Result.ok();
    }

    @ApiOperation(value = "删除设备")
    @GetMapping(value = "/delDevice")
    public Result delDevice(@RequestParam(value = "id") String id) {
        thirdpartyService.delDevice(id);
        return Result.ok();
    }

    @ApiOperation(value = "查询设备当前状态列表")
    @GetMapping(value = "/getDeviceStatusList")
    public Result getDeviceStatusList() {
        return Result.ok().setData(thirdpartyService.getDeviceStatusList());
    }

    @ApiOperation(value = "查询设备状态详情列表")
    @GetMapping(value = "/getDeviceStatusDetailList")
    public Result getDeviceStatusDetailList(
            @RequestParam(value = "deviceId") String deviceId) {
        return Result.ok().setData(thirdpartyService.getDeviceStatusDetailList(deviceId));
    }

    @ApiOperation(value = "导出设备当前状态列表")
    @GetMapping(value = "/exportDeviceStatusList")
    public Result exportDeviceStatusList() {
        return Result.ok();
    }

    @ApiOperation(value = "导出设备状态详情列表")
    @GetMapping(value = "/exportDeviceStatusDetailList")
    public Result exportDeviceStatusDetailList() {
        return Result.ok();
    }

}
