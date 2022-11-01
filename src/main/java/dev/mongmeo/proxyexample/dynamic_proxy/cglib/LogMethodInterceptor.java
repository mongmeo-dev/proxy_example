package dev.mongmeo.proxyexample.dynamic_proxy.cglib;

import java.lang.reflect.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

@Slf4j
@RequiredArgsConstructor
public class LogMethodInterceptor implements MethodInterceptor {

  private final Object target;

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    String className = method.getDeclaringClass().getSimpleName();
    String methodName = method.getName();
    String logPrefix = "[" + className + "." + methodName + "()]";

    long startTime = System.currentTimeMillis();
    log.info("{} - Called!", logPrefix);
    try {
      log.info("{} - Main Logic Started!!", logPrefix);

      Object result = methodProxy.invoke(target, objects);

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
