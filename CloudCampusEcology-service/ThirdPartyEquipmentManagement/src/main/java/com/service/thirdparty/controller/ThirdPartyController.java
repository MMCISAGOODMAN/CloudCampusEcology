package com.service.thirdparty.controller;

import com.service.thirdparty.feign.RemoteDakaService;
import com.service.thirdparty.service.ThirdPartyService;
import com.service.thirdparty.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ThirdPartyController
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/17 13:59
 * @Version 1.0
 */
@Api(description = "第三方设备纳管控制器")
@RestController
@RequestMapping("/thirdParty")
public class ThirdPartyController {

    @Resource
    private ThirdPartyService thirdPartyService;

    @Resource
    private RemoteDakaService remoteDakaService;

    @ApiOperation(value = "获取列表")
    @GetMapping(value = "/getList")
    // @HystrixCommand(fallbackMethod = "defaultStores")
    public Result getList() {
        System.out.println("这是第二个微服务");
        return Result.ok().setData("success");
    }

    //熔断，单位时间内不会再请求接口
    public Result defaultStores() {
        return Result.failure("failed");
    }

    @ApiOperation(value = "feign测试")
    @GetMapping(value = "/getFeign")
    public Result getFeign() {

        return Result.ok().setData(thirdPartyService.getFeign());
    }

    @ApiOperation(value = "获取设备信息")
    @GetMapping(value = "/getDeviceList")
    public Result getDeviceList() {

        return Result.ok().setData(thirdPartyService.getDeviceList());
    }

    @ApiOperation(value = "获取feign信息")
    @GetMapping(value = "/getDakaFeign")
    public Result getDakaFeign() {

        return Result.ok().setData(remoteDakaService.getList(1, 10));
    }

}
