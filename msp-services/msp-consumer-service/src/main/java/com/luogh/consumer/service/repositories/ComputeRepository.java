package com.luogh.consumer.service.repositories;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luogh
 */

@FeignClient(value = "msp-compute-service", fallback = ComputeHystrix.class)
public interface ComputeRepository {

    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    int compute(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2);
}
