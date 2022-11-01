package dev.mongmeo.proxyexample.decorator;

import org.junit.jupiter.api.Test;

class DecoratorTest {

  @Test
  void test() throws Exception {
    Component repository = new LogDecorator(new HelloRepositoryComponent());
    Component decoratedController = new LogDecorator(new HelloControllerComponent(repository));

    decoratedController.execute();
  }
}