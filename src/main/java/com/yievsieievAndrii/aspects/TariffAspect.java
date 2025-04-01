package com.volodymyrKadomtsev.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.volodymyrKadomtsev.carsharing.Carsharing;
import com.volodymyrKadomtsev.carsharing.TariffType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TariffAspect
 */
@Aspect
@Component
public class TariffAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.volodymyrKadomtsev.carsharing.CarsharingService.bookCar(..)) && args(carsharing)")
  public void setStandardTariff(Carsharing carsharing) {
    logger.info("Setting standard tariff for carsharing: {}", carsharing);
    if (carsharing.getTariff() == null) {
      carsharing.setTariff(TariffType.STANDARD);
    }
  }

}
