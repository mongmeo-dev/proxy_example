package dev.mongmeo.proxyexample.proxy.inter.impl;


import dev.mongmeo.proxyexample.proxy.inter.HelloController;
import dev.mongmeo.proxyexample.proxy.inter.HelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class HelloControllerImpl implements HelloController {

  private final HelloRepository helloRepository;

  @Override
  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
