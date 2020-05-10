package ar.edu.unq.aspects.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LogExecutionTimeAspectCustomPointcut  {

	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectCustomPointcut.class);
	
	/// CUSTOM  POINTCUT////
	@Pointcut("execution(* ar.edu.unq.aspects.example.StarterServiceController.*(..))")
	public void methodsStarterServicePointcut() {
	}

	@Before("methodsStarterServicePointcut()")
	public void beforeMethods() throws Throwable {
		logger.info("/////// BEFORE /////");
	}

	@After("methodsStarterServicePointcut()")
	public void afterMethods() throws Throwable {
		logger.info("/////// AFTER  /////");
	}
}
