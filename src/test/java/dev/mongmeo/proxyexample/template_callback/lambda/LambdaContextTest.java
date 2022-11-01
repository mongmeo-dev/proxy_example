package dev.mongmeo.proxyexample.template_callback.lambda;

import dev.mongmeo.proxyexample.template_callback.Callback;
import dev.mongmeo.proxyexample.template_callback.Context;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class LambdaContextTest {

  @Test
  void test() {

    Callback helloController = new Callback() {
      private final Context context = new Context((args) -> {
        Thread.sleep(1000);
        return "hello";
      });

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