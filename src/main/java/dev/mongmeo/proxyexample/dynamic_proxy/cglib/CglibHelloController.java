package dev.mongmeo.proxyexample.dynamic_proxy.cglib;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CglibHelloController {

  private final CglibHelloRepository helloRepository;

  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
