package dev.mongmeo.proxyexample.aop.concrete;

import org.springframework.stereotype.Component;

@Component
public class AopConcreteHelloRepository {

  public String getHello() {
    try {
      Thread.sleep(1000);
      return "hello";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
