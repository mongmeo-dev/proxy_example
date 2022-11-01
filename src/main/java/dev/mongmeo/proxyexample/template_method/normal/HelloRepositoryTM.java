package dev.mongmeo.proxyexample.template_method.normal;

import dev.mongmeo.proxyexample.template_method.AbstractLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloRepositoryTM extends AbstractLogTemplate<String> {

  @Override
  protected String logic(Object... args) throws Exception {
    Thread.sleep(1000);
    return "hello";
  }
}