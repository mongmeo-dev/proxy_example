package dev.mongmeo.proxyexample.normal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloRepository {

  public String getHelloData() {
    long startTime = System.currentTimeMillis();
    log.info("[HelloRepository.getHelloData()] - Called!");
    try {
      log.info("[HelloRepository.getHelloData()] - Main Logic Start");

      // main logic - start
      Thread.sleep(1000);
      String result = "hello";
      // main logic - end

      long endTime = System.currentTimeMillis();
      long elapsedTime = endTime - startTime;
      log.info("[HelloRepository.getHelloData()] - Finish! Elapsed Time : {}ms", elapsedTime);
      return result;
    } catch (Exception e) {
      log.error("[HelloRepository.getHelloData()] - Exception Occurred!");
      throw new RuntimeException(e);
    }
  }
}