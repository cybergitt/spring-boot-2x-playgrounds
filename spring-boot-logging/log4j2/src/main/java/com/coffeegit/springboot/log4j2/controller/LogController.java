package com.coffeegit.springboot.log4j2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
	
	// Creating a logger
	Logger logger = LogManager.getLogger(LogController.class);
	
	@RequestMapping("/log")
	public String log() {
		// Logging various log level messages
        logger.trace("Log level: TRACE");
        logger.info("Log level: INFO");
        logger.debug("Log level: DEBUG");
        logger.error("Log level: ERROR");
        logger.warn("Log level: WARN");
  
        return "Hey! You can check the output in the logs";
	}
}
