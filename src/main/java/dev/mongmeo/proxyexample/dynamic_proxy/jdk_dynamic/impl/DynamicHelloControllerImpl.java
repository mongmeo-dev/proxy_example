package dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.impl;


import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloController;
import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DynamicHelloControllerImpl implements DynamicHelloController {

  private final DynamicHelloRepository helloRepository;

  @Override
  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
