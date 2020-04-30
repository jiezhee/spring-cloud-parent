package com.eris.cloud.cloudclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
@Slf4j
public class FeignController {

    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("/feign")
    public void test() {
        for (int i = 0; i < 20; i++) {
            String response = feignInterface.request(i);
            log.info("client receive response. i:{},res:{}", i, response);
        }
    }

    @GetMapping("/hystrix-text")
    @HystrixCommand(fallbackMethod = "error",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "110")
            })
    public String test1() {
        return feignInterface.hystrixTest();
    }

    public String error() {
        log.warn("circuit broken");
        return "timeout error";
    }

}
