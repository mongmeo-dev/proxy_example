package dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.impl;


import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloController;
import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloRepository;
import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.LogInvocationHandler;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;


class DynamicHelloControllerImplTest {


  @Test
  void test() {
    DynamicHelloRepository helloRepository = new DynamicHelloRepositoryImpl();
    DynamicHelloRepository proxyHelloRepository = (DynamicHelloRepository) Proxy.newProxyInstance(
        DynamicHelloRepository.class.getClassLoader(),
        new Class[]{DynamicHelloRepository.class},
        new LogInvocationHandler(helloRepository));

    DynamicHelloController helloController = new DynamicHelloControllerImpl(proxyHelloRepository);
    DynamicHelloController proxyHelloController = (DynamicHelloController) Proxy.newProxyInstance(
        DynamicHelloController.class.getClassLoader(),
        new Class[]{DynamicHelloController.class},
        new LogInvocationHandler(helloController));

    proxyHelloController.execute();;
  }

}