package ar.edu.unq.aspects.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.aspects.example.LogExecutionTime;
import ar.edu.unq.aspects.example.LogExecutionTimeAspectAnnotation;

@RestController
@EnableAutoConfiguration
public class RestExampleController {

	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectAnnotation.class);

	@LogExecutionTime
	@GetMapping("/method1")
	public void method1(@RequestHeader(value = "User-Agent") String userAgent) {
		logger.info("/////// Inside method1()");
	}

	@GetMapping("/method2")
	public void method2() {
		logger.info("/////// Inside method2() <RESTCONTROLLER>");
	}

}
