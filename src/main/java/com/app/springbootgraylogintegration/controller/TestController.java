package com.app.springbootgraylogintegration.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/graylog")
public class TestController {
    private static final Logger logger = LogManager.getLogger(TestController.class);

    @GetMapping("/logger")
    public void test() {
        logger.info("Hello from Spring Boot Graylog Integration Application!");
    }
}
