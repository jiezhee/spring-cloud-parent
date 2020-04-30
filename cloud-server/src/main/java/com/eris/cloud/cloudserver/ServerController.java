package com.eris.cloud.cloudserver;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/server")
@Slf4j
public class ServerController {


    @GetMapping("/str/{id}")
    public String test(@PathVariable int id) {
        log.info("server receive request, id:{}", id);
        return "i=" + id + ". " + RandomStringUtils.randomAlphabetic(5);
    }
}
