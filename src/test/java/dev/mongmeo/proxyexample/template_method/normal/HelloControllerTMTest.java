package dev.mongmeo.proxyexample.template_method.normal;

import org.junit.jupiter.api.Test;

class HelloControllerTMTest {

  private final HelloControllerTM controller = new HelloControllerTM();

  @Test
  void test() {
    controller.execute();
  }

}