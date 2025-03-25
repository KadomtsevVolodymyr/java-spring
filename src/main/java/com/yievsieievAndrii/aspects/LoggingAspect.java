
package com.yievsieievAndrii.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingAspect
 */
@Aspect
@Component
public class LoggingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @AfterReturning(pointcut = "execution(* com.yievsieievAndrii.carsharing.CarsharingController.*(..))", returning = "result")
  public void afterCarLogging(JoinPoint joinPoint, Object result) {
    Object[] args = joinPoint.getArgs();
    logger.info("Args of car: {}", args);
    logger.info("Args of car: {}", result);
  }

}
