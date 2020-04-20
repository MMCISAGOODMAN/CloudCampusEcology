package com.service.thirdparty.feign;

import com.service.thirdparty.feign.factory.RemoteDakaFallbackFactory;
import demo.common.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign服务层
 *
 * @author mamingcong
 * @date 2020-04-19
 */
@FeignClient(name = ServiceNameConstants.SERVICE_DAKA, fallbackFactory = RemoteDakaFallbackFactory.class)
public interface RemoteDakaService {
    @GetMapping("news/getList")
    public Object getList(@RequestParam(value = "pageNum", required = true) int pageNum,
                          @RequestParam(value = "pageSize", required = true) int pageSize);
}
