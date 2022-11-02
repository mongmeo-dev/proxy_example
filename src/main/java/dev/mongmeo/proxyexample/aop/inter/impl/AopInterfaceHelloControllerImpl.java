package dev.mongmeo.proxyexample.aop.inter.impl;


import dev.mongmeo.proxyexample.aop.inter.AopInterfaceHelloController;
import dev.mongmeo.proxyexample.aop.inter.AopInterfaceHelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AopInterfaceHelloControllerImpl implements AopInterfaceHelloController {

  private final AopInterfaceHelloRepository helloRepository;

  @Override
  public void execute() {
    String result = helloRepository.getHello();
    log.info("result : {}", result);
  }
}
