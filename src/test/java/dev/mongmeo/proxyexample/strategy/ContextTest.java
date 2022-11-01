package dev.mongmeo.proxyexample.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContextTest {

  private final Context context = new Context(new HelloControllerStrategy());

  @Test
  void test() {
    context.execute();
  }

}