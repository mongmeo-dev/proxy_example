package dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.impl;


import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloController;
import dev.mongmeo.proxyexample.dynamic_proxy.jdk_dynamic.DynamicHelloRepository;
import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.FactoryInterfaceHelloController;
import dev.mongmeo.proxyexample.dynamic_proxy.proxy_factory.inter.FactoryInterfaceHelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FactoryInterfaceHelloControllerImpl implements FactoryInterfaceHelloController {

  private final FactoryInterfaceHelloRepository helloRepository;

  @Override
  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
