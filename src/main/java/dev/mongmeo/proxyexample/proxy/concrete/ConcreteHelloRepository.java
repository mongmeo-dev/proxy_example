package dev.mongmeo.proxyexample.proxy.concrete;

public class ConcreteHelloRepository {

  public String getHello() {
    try {
      Thread.sleep(1000);
      return "hello";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
