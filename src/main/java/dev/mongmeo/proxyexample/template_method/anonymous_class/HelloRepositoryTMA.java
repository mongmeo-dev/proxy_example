package dev.mongmeo.proxyexample.template_method.anonymous_class;

import dev.mongmeo.proxyexample.template_method.AbstractLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloRepositoryTMA {

  public String getHelloData() {
    AbstractLogTemplate<String> template = new AbstractLogTemplate<>() {
      @Override
      protected String logic(Object... args) throws Exception {
        Thread.sleep(1000);
        return "hello";
      }
    };
    return template.execute();
  }


}