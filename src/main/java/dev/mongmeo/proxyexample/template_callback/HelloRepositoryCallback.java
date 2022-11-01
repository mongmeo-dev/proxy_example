package dev.mongmeo.proxyexample.template_callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloRepositoryCallback implements Callback {

  @Override
  public Object execute(Object... args) throws Exception {
    Thread.sleep(1000);
    return "hello";
  }
}