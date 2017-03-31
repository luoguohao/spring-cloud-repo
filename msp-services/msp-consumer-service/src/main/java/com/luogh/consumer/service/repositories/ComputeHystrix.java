package com.luogh.consumer.service.repositories;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luogh
 */
@Component
@Slf4j
public class ComputeHystrix implements ComputeRepository {
    @Override
    public int compute(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2) {
        log.info("fallback compute, using default value={}.", -1);
        return -1;
    }
}
