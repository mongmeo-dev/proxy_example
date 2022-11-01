package dev.mongmeo.proxyexample.template_method.anonymous_class;

import org.junit.jupiter.api.Test;

class HelloControllerTMATest {

  private final HelloControllerTMA controller = new HelloControllerTMA();

  @Test
  void test() {
    controller.execute();
  }
}