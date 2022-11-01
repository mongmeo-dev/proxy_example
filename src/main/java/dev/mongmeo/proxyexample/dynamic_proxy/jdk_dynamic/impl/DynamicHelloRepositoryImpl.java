package dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.impl;

import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloRepository;

public class DynamicHelloRepositoryImpl implements DynamicHelloRepository {

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
