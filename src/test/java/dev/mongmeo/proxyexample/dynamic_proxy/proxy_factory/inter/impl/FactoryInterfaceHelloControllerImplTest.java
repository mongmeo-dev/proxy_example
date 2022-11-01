package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.impl;

import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.FactoryLogMethodInterceptor;
import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.FactoryInterfaceHelloController;
import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.FactoryInterfaceHelloRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
class FactoryInterfaceHelloControllerImplTest {

  @Test
  void test() {
    FactoryInterfaceHelloRepository realRepository = new FactoryInterfaceHelloRepositoryImpl();
    ProxyFactory repositoryProxyFactory = new ProxyFactory(realRepository);
    repositoryProxyFactory.addAdvice(new FactoryLogMethodInterceptor());
    FactoryInterfaceHelloRepository proxyRepository = (FactoryInterfaceHelloRepository) repositoryProxyFactory.getProxy();

    FactoryInterfaceHelloController realController = new FactoryInterfaceHelloControllerImpl(
        proxyRepository);
    ProxyFactory controllerProxyFactory = new ProxyFactory(realController);
    controllerProxyFactory.addAdvice(new FactoryLogMethodInterceptor());
    FactoryInterfaceHelloController proxyController = (FactoryInterfaceHelloController) controllerProxyFactory.getProxy();

    proxyController.execute();

    log.info("FactoryConcreteHelloController proxy class = {}",
        proxyController.getClass().getSimpleName());
  }

}