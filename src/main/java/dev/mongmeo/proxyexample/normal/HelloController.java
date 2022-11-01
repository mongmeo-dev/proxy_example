package dev.mongmeo.proxyexample.normal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloController {

  private final HelloRepository helloRepository = new HelloRepository();

  public void execute() {
    long startTime = System.currentTimeMillis();
    log.info("[HelloController.logic()] - Called!");
    try {
      log.info("[HelloController.logic()] - Main Logic Start");

      // main logic - start
      String result = helloRepository.getHelloData();
      log.info("result : {}", result);
      // main logic - end

      long endTime = System.currentTimeMillis();
      long elapsedTime = endTime - startTime;
      log.info("[HelloController.logic()] - Finish! Elapsed Time : {}ms", elapsedTime);
    } catch (Exception e) {
      log.error("[HelloController.logic()] - Exception Occurred!");
      throw new RuntimeException(e);
    }

  }
}

