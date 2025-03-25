
package com.yievsieievAndrii.aspects;

import org.apache.logging.log4j.message.SimpleMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.yievsieievAndrii.carsharing.Carsharing;
import com.yievsieievAndrii.carsharing.TariffType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingAspect
 */
@Aspect
@Component
public class LoggingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private JavaMailSender javaMailSender;

  @AfterReturning(pointcut = "execution(* com.yievsieievAndrii.carsharing.CarsharingController.*(..))", returning = "result")
  public void afterCarLogging(JoinPoint joinPoint, Object result) {
    Object[] args = joinPoint.getArgs();
    logger.info("Args of car: {}", args);
    logger.info("Args of car: {}", result);

    sendEmailNotification(joinPoint.getSignature().toShortString(), args, result);
  }

  @Before("execution(* com.yievsieievAndrii.carsharing.CarsharingService.bookCar(..)) && args(carsharing)")
  public void setStandardTariff(JoinPoint joinPoint, Carsharing carsharing) {
    logger.info("Setting standard tariff for carsharing: {}", carsharing);
    if (carsharing.getTariff() == null) {
      carsharing.setTariff(TariffType.STANDARD);
    }

    sendEmailNotification(joinPoint.getSignature().toShortString(), new Object[]{carsharing}, null);
  }

  private void sendEmailNotification(String method, Object[] args, Object result) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("bobross9855@gmail.com");
    message.setSubject("Method Execute");
    message.setText("Method: " + method + "\nArgs: " + java.util.Arrays.toString(args) + "\nResult: " + result);

    javaMailSender.send(message);
  }

}
