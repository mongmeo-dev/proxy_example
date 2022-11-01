package dev.mongmeo.proxyexample.template_method.normal;

import dev.mongmeo.proxyexample.template_method.AbstractLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloControllerTM extends AbstractLogTemplate<Void> {

  private final HelloRepositoryTM helloRepository = new HelloRepositoryTM();

  @Override
  protected Void logic(Object... args) {
    String result = helloRepository.getHelloData();
    log.info("result : {}", result);
    return null;
  }
}

