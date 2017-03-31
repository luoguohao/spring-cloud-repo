package com.luogh.consumer.service;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author luogh
 */
public class SimpleTest {

    @Test
    public void testURI() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://msp-compute-service/compute")
                .queryParam("param1", "1")
                .queryParam("param2", "2");
        URI uri = builder.build().encode().toUri();
        System.out.println(uri);
    }
}
