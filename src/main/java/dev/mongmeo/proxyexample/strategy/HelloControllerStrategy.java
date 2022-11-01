package dev.mongmeo.proxyexample.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloControllerStrategy implements Strategy {

  private final HelloRepositoryStrategy helloRepository = new HelloRepositoryStrategy();
  private final Context context = new Context(helloRepository);

  @Override
  public Object execute(Object... args) throws Exception {
    Object result = context.execute();
    log.info("result : {}", result);

    return null;
  }
}

