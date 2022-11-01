package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.concrete;


import dev.mongmeo.proxyexample.dynamic_proxy.cglib.CglibHelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FactoryConcreteHelloController {

  private final FactoryConcreteHelloRepository helloRepository;

  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
