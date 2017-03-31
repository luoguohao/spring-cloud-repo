package com.luogh.consumer.service.repositories;

import com.google.common.base.Throwables;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * @author luogh
 */
@Service
@Slf4j
public class ComputeRepositoryV2 {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "consumerFallback",
            commandProperties = {
                @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="100")
            })
    public int consumerUsingRest(Map<String, String> params) {
        log.info("request with params={}.", params);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://msp-compute-service/compute")
                                        .queryParam("param1", params.get("param1"))
                                        .queryParam("param2", params.get("param2"));
        URI uri = builder.build().encode().toUri();
        log.info("request with params={}, uri={}.", params, uri);
        HttpEntity<Integer> response = restTemplate.getForEntity(uri, Integer.class);
        int result = response.getBody();
        log.info("result={}.", result);
        return result;
    }

    public int consumerFallback(Map<String, Object> params, Throwable e) {
        log.info("using default fallback operations, the reason why fallback is:{}.", Throwables.getStackTraceAsString(e));
        return -2;
    }
}
