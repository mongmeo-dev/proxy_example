package dev.mongmeo.proxyexample.dynamic_proxy.cglib;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

class CglibHelloControllerTest {

  @Test
  void cglib() {
    Enhancer repositoryEnhancer = new Enhancer();
    CglibHelloRepository realRepository = new CglibHelloRepository();
    repositoryEnhancer.setSuperclass(CglibHelloRepository.class);
    repositoryEnhancer.setCallback(new LogMethodInterceptor(realRepository));
    CglibHelloRepository proxyRepository = (CglibHelloRepository) repositoryEnhancer.create();

    Enhancer controllerEnhancer = new Enhancer();
    CglibHelloController realController = new CglibHelloController(proxyRepository);
    controllerEnhancer.setSuperclass(CglibHelloController.class);
    controllerEnhancer.setCallback(new LogMethodInterceptor(realController));
    CglibHelloController proxyController = (CglibHelloController) controllerEnhancer.create(new Class[]{
        CglibHelloRepository.class}, new Object[]{new CglibHelloRepository()});

    proxyController.execute();
  }

}