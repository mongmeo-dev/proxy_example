package dev.mongmeo.proxyexample.aop.warn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AopWarn {

  public void outerCall() {
    log.info("outerCall");
    innerCall();
  }

  public void innerCall() {
    log.info("innerCall");
  }
}
