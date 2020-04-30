package com.eris.cloud.cloudserver;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/server")
@Slf4j
public class ServerHystrixController {

    @GetMapping("/hystrix")
    public long test() {
        long start = System.currentTimeMillis();
        int i = RandomUtils.nextInt(100, 120);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
        }
        log.info(i > 110 ? "server timeout" : "server normal");
        return System.currentTimeMillis() - start;

    }
}
