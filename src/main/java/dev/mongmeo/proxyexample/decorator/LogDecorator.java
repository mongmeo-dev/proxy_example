package dev.mongmeo.proxyexample.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDecorator extends Decorator {

  public LogDecorator(Component component) {
    super(component);
  }

  @Override
  public Object execute(Object... args) throws Exception {
    String className = this.getClass().getSimpleName();
    String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

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