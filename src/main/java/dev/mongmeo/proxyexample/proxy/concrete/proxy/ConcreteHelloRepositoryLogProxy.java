package dev.mongmeo.proxyexample.proxy.concrete.proxy;

import dev.mongmeo.proxyexample.proxy.concrete.ConcreteHelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ConcreteHelloRepositoryLogProxy extends ConcreteHelloRepository {

  private final ConcreteHelloRepository target;

  @Override
  public String getHello() {
    String className = this.target.getClass().getSimpleName();
    String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      String result = target.getHello();

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
