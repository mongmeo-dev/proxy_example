package dev.mongmeo.proxyexample.template_callback.anonymous_interface;

import dev.mongmeo.proxyexample.template_callback.Callback;
import dev.mongmeo.proxyexample.template_callback.Context;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class AnonymousContextTest {

  @Test
  void test() throws Exception {

    Callback helloRepository = new Callback() {
      @Override
      public Object execute(Object... args) throws Exception {
        Thread.sleep(1000);
        return "hello";
      }
    };

    Callback helloController = new Callback() {
      private final Context context = new Context(
          helloRepository);

      @Override
      public Object execute(Object... args) throws Exception {
        Object result = context.execute();
        log.info("result : {}", result);

        return null;
      }
    };

    Context context = new Context(helloController);
    context.execute();
  }
}