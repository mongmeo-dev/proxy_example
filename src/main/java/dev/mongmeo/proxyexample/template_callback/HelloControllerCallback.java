package dev.mongmeo.proxyexample.template_callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloControllerCallback implements Callback {

  private final HelloRepositoryCallback helloRepository = new HelloRepositoryCallback();
  private final Context context = new Context(helloRepository);

  @Override
  public Object execute(Object... args) throws Exception {
    Object result = context.execute();
    log.info("result : {}", result);

    return null;
  }
}

