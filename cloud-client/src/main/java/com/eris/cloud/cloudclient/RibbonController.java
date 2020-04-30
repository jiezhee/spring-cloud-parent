package com.eris.cloud.cloudclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public void test() {
        for (int i = 0; i < 20; i++) {
            restTemplate.getForObject("http://CLOUD-SERVER/server/str/" + i, String.class);
        }
    }
}
