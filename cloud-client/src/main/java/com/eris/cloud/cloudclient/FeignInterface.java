package com.eris.cloud.cloudclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("CLOUD-SERVER")
public interface FeignInterface {

    @GetMapping("/server/str/{id}")
    public String request(@PathVariable int id);

    @PostMapping("/insert")
    public String postRequest(@RequestBody Map<Object, Object> map, @RequestHeader("id") int id);

    @GetMapping("/server/hystrix")
    public String hystrixTest();
}
