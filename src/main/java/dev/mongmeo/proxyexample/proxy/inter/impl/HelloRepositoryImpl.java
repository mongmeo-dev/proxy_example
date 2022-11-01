package dev.mongmeo.proxyexample.proxy.inter.impl;

import dev.mongmeo.proxyexample.proxy.inter.HelloRepository;

public class HelloRepositoryImpl implements HelloRepository {

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
