package dev.mongmeo.proxyexample.dynamic_proxy.cglib;

public class CglibHelloRepository {

  public String getHello() {
    try {
      Thread.sleep(1000);
      return "hello";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
