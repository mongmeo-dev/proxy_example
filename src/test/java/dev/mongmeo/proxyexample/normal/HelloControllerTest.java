package dev.mongmeo.proxyexample.normal;

import dev.mongmeo.proxyexample.normal.HelloController;
import org.junit.jupiter.api.Test;

class HelloControllerTest {

  private final HelloController controller = new HelloController();

  @Test
  void helloControllerTest() {
    controller.execute();
  }

}