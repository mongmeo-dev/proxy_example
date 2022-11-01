package dev.mongmeo.proxyexample.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloControllerComponent extends Component {

  private final Component helloRepository;

  public HelloControllerComponent(Component helloRepository) {
    this.helloRepository = helloRepository;
  }

  @Override
  public Object execute(Object... args) throws Exception {
    Object result = helloRepository.execute();
    log.info("result : {}", result);

    return null;
  }
}
