package dev.mongmeo.proxyexample.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloRepositoryStrategy implements Strategy {

  @Override
  public Object execute(Object... args) throws Exception {
    Thread.sleep(1000);
    return "hello";
  }
}