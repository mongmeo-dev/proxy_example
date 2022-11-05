package dev.mongmeo.proxyexample.aop.warn;

import dev.mongmeo.proxyexample.config.SpringConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AopWarnTest {

  private final ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

  @Test
  @DisplayName("메서드 내부에서 호출하는 매서드는 aop가 적용되지 않는다")
  void aopNotWorkingOnInnerCallMethod() {
    AopWarn aopWarn = ctx.getBean(AopWarn.class);
    aopWarn.outerCall();
  }
}