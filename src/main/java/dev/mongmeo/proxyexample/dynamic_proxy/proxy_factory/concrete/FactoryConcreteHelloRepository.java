package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.concrete;

public class FactoryConcreteHelloRepository {

  public String getHello() {
    try {
      Thread.sleep(1000);
      return "hello";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
