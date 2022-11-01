package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.impl;

import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.FactoryInterfaceHelloRepository;

public class FactoryInterfaceHelloRepositoryImpl implements FactoryInterfaceHelloRepository {

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
