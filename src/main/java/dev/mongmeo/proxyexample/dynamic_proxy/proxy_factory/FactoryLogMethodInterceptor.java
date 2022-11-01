package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class FactoryLogMethodInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    String className = invocation.getMethod().getDeclaringClass().getSimpleName();
    String methodName = invocation.getMethod().getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      Object result = invocation.proceed();

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
