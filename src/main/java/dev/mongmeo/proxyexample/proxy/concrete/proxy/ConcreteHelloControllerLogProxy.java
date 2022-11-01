package dev.mongmeo.proxyexample.proxy.concrete.proxy;

import dev.mongmeo.proxyexample.proxy.concrete.ConcreteHelloController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteHelloControllerLogProxy extends ConcreteHelloController {

  private final ConcreteHelloController target;

  public ConcreteHelloControllerLogProxy(ConcreteHelloController target) {
    super(null);
    this.target = target;
  }

  @Override
  public void execute() {
    String className = this.target.getClass().getSimpleName();
    String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      target.execute();

      long endTime = System.currentTimeMillis();
      long elapsedTime = endTime - startTime;
      log.info("{} - Finish! Elapsed Time : {}ms", logPrefix, elapsedTime);

    } catch (Exception e) {
      log.error("{} - exception occurred!", logPrefix, e);
      throw new RuntimeException(e);
    }
  }
}