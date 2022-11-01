package dev.mongmeo.proxyexample.template_method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractLogTemplate<T> {

  public T execute(Object... args) {
    String className = this.getClass().getSimpleName();
    String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      T result = logic();

      long endTime = System.currentTimeMillis();
      long elapsedTime = endTime - startTime;
      log.info("{} - Finish! Elapsed Time : {}ms", logPrefix, elapsedTime);

      return result;
    } catch (Exception e) {
      log.error("{} - exception occurred!", logPrefix, e);
      throw new RuntimeException(e);
    }
  }

  protected abstract T logic(Object... args) throws Exception;
}
