package dev.mongmeo.proxyexample.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDecorator extends Decorator {

  private final String COMPONENT_CLASS_NAME;

  public LogDecorator(Component component) {
    super(component);
    COMPONENT_CLASS_NAME = component.getClass().getSimpleName();
  }

  @Override
  public Object execute(Object... args) throws Exception {
    String logPrefix = "[" + COMPONENT_CLASS_NAME + "." + "execute()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      Object result = super.execute(args);

      long endTime = System.currentTimeMillis();
      long elapsedTime = endTime - startTime;
      log.info("{} - Finish! Elapsed Time : {}ms", logPrefix, elapsedTime);

      return result;
    } catch (Exception e) {
      log.error("{} - exception occurred!", logPrefix, e);
      throw new RuntimeException(e);
    }
  }
}