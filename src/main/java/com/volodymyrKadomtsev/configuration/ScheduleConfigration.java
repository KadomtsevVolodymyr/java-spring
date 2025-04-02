
package com.volodymyrKadomtsev.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ScheduleConfigration
 */
@EnableScheduling
@Component
public class ScheduleConfigration {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Scheduled(fixedRate = 90, initialDelay = 18, timeUnit = TimeUnit.SECONDS)
  public void doSomething() {
    logger.info("API для каршерінгу");
  }

}
