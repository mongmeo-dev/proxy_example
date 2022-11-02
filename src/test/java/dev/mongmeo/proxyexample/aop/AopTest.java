package dev.mongmeo.proxyexample.aop;

import dev.mongmeo.proxyexample.aop.concrete.AopConcreteHelloController;
import dev.mongmeo.proxyexample.aop.inter.AopInterfaceHelloController;
import dev.mongmeo.proxyexample.config.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
class AopTest {

  private final ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

  @Test
  void concreteTest() {
    AopConcreteHelloController concreteBean = ctx.getBean(AopConcreteHelloController.class);
    log.info("concreteBean : {}", concreteBean.getClass().getSimpleName());
    concreteBean.execute();
  }

  @Test
  void interfaceTest() {
    AopInterfaceHelloController interfaceBean = ctx.getBean(AopInterfaceHelloController.class);
    log.info("interfaceBean : {}", interfaceBean.getClass().getSimpleName());
    interfaceBean.execute();
  }

}