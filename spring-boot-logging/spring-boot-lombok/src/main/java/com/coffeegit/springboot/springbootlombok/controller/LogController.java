package com.coffeegit.springboot.springbootlombok.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogController {
	
	@RequestMapping("/log")
	public String log() {
		// Logging various log level messages
        log.trace("Log level: TRACE");
        log.info("Log level: INFO");
        log.debug("Log level: DEBUG");
        log.error("Log level: ERROR");
        log.warn("Log level: WARN");
  
        return "Hey! You can check the output in the logs";
	}
}
