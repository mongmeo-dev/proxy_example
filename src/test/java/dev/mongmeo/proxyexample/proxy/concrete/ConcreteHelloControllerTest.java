package dev.mongmeo.proxyexample.proxy.concrete;

import static org.junit.jupiter.api.Assertions.*;

import dev.mongmeo.proxyexample.proxy.concrete.proxy.ConcreteHelloControllerLogProxy;
import dev.mongmeo.proxyexample.proxy.concrete.proxy.ConcreteHelloRepositoryLogProxy;
import org.junit.jupiter.api.Test;

class ConcreteHelloControllerTest {

  @Test
  void test() {
    ConcreteHelloRepository realRepository = new ConcreteHelloRepository();
    ConcreteHelloRepository proxyRepository = new ConcreteHelloRepositoryLogProxy(realRepository);
    ConcreteHelloController realController = new ConcreteHelloController(proxyRepository);
    ConcreteHelloController proxyController = new ConcreteHelloControllerLogProxy(realController);

    proxyController.execute();
  }

}