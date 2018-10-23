package ar.edu.unq.aspects.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class StarterServiceController {
	
	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspect.class);
	
	@LogExecutionTime
	@GetMapping("/method1")
	public void method1() {
		logger.info("Inside method1() method");
		
	}
	
	@GetMapping("/method2")
	public void method2() {
		logger.info("Inside method2() method");
		
	}


}
