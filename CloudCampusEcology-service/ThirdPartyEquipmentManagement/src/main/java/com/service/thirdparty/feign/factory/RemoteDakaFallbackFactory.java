package com.service.thirdparty.feign.factory;

import com.service.thirdparty.feign.RemoteDakaService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteDakaFallbackFactory implements FallbackFactory<RemoteDakaService> {

    @Override
    public RemoteDakaService create(Throwable throwable) {

        log.error(throwable.getMessage());

        return new RemoteDakaService() {
            @Override
            public Object getList(int pageNum, int pageSize) {
                return "远程调用失败了";
            }
        };
    }
}
