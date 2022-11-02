package dev.mongmeo.proxyexample.aop.inter.impl;

import dev.mongmeo.proxyexample.aop.inter.AopInterfaceHelloRepository;
import org.springframework.stereotype.Component;

@Component
public class AopInterfaceHelloRepositoryImpl implements AopInterfaceHelloRepository {

  @Override
  public String getHello() {
    try {
      Thread.sleep(1000);
      return "hello";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
