package com.luogh.consumer.service.controllers;

import com.google.common.collect.Maps;
import com.luogh.consumer.service.repositories.ComputeRepository;
import com.luogh.consumer.service.repositories.ComputeRepositoryV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author luogh
 */
@RefreshScope
@RestController
@Slf4j
public class ConsumerController {

    @Value("${ip}")
    private String ip;

    @Autowired
    private ComputeRepository computeRepository;

    @Autowired
    private ComputeRepositoryV2 computeRepositoryV2;


    @RequestMapping("/config")
    public String config() {
        return this.ip;
    }

    @RequestMapping("/consumer")
    public int compute(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2) {
       return computeRepository.compute(param1, param2 + 100);
    }

    @RequestMapping("/consumerUsingRest")
    public int consumerUsingRest(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2) {
        Map<String, String> params = Maps.newHashMap();
        params.put("param1", param1.toString());
        params.put("param2", param2.toString());
        return computeRepositoryV2.consumerUsingRest(params);
    }


}
