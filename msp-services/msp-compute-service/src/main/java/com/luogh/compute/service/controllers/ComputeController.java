package com.luogh.compute.service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luogh
 */
@RefreshScope
@RestController
public class ComputeController {

    @Value("${username}")
    private String username;

    @RequestMapping("/config")
    public String config() {
        return this.username;
    }

    @RequestMapping("/compute")
    public int compute(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2) {
        return param1 + param2;
    }
}
