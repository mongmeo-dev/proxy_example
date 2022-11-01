package dev.mongmeo.proxyexample.proxy.inter.impl;

import dev.mongmeo.proxyexample.proxy.inter.HelloController;
import dev.mongmeo.proxyexample.proxy.inter.HelloRepository;
import dev.mongmeo.proxyexample.proxy.inter.proxy.HelloControllerLogProxy;
import dev.mongmeo.proxyexample.proxy.inter.proxy.HelloRepositoryLogProxy;
import org.junit.jupiter.api.Test;

class HelloControllerImplTest {

  @Test
  void test() {
    HelloRepository realHelloRepository = new HelloRepositoryImpl();
    HelloRepository proxyHelloRepository = new HelloRepositoryLogProxy(realHelloRepository);
    HelloController realHelloController = new HelloControllerImpl(proxyHelloRepository);
    HelloController proxyHelloController = new HelloControllerLogProxy(realHelloController);

    proxyHelloController.execute();
  }

}