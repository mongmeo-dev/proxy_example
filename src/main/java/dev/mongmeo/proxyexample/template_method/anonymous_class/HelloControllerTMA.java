package dev.mongmeo.proxyexample.template_method.anonymous_class;

import dev.mongmeo.proxyexample.template_method.AbstractLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloControllerTMA {

  private final HelloRepositoryTMA helloRepository = new HelloRepositoryTMA();

  public void execute() {
    AbstractLogTemplate<Void> template = new AbstractLogTemplate<Void>() {
      @Override
      protected Void logic(Object... args) throws Exception {

        String result = helloRepository.getHelloData();
        log.info("result : {}", result);
        return null;
      }
    };

    template.execute();
  }
}

