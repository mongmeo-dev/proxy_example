package dev.mongmeo.proxyexample.proxy.concrete;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ConcreteHelloController {

  private final ConcreteHelloRepository helloRepository;

  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
