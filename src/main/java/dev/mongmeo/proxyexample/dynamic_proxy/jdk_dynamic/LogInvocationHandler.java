package dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * JDK Dynamic Proxy. 인터페이스가 있는 경우에만 사용 가능하다.
 */
@Slf4j
@RequiredArgsConstructor
public class LogInvocationHandler implements InvocationHandler {

  private final Object target;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String className = method.getDeclaringClass().getSimpleName();
    String methodName = method.getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      Object result = method.invoke(target, args);

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
