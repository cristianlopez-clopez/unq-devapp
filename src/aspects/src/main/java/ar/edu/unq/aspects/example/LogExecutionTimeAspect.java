package ar.edu.unq.aspects.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {

	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

	/// ANNOTATION POINTCUT////
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("/////// AROUND Start logExecutionTime annotation //////");
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		logger.info("/////// AROUND Finish logExecutionTime annotation ///////");
		return proceed;
	}

	/// CUSTOM  POINTCUT////
	@Pointcut("execution(* ar.edu.unq.aspects.example.StarterService.*(..))")
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