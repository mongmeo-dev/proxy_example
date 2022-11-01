package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.concrete;

import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.FactoryLogMethodInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
class FactoryConcreteHelloRepositoryTest {

  @Test
  void test() {
    FactoryConcreteHelloRepository realRepository = new FactoryConcreteHelloRepository();
    ProxyFactory repositoryProxyFactory = new ProxyFactory(realRepository);
    repositoryProxyFactory.addAdvice(new FactoryLogMethodInterceptor());
    FactoryConcreteHelloRepository proxyRepository = (FactoryConcreteHelloRepository) repositoryProxyFactory.getProxy();

    FactoryConcreteHelloController realController = new FactoryConcreteHelloController(
        proxyRepository);
    ProxyFactory controllerProxyFactory = new ProxyFactory(realController);
    controllerProxyFactory.addAdvice(new FactoryLogMethodInterceptor());
    FactoryConcreteHelloController proxyController = (FactoryConcreteHelloController) controllerProxyFactory.getProxy();

    proxyController.execute();

    log.info("FactoryConcreteHelloController proxy class = {}",
        proxyController.getClass().getSimpleName());
  }

}