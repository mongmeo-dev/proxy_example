package dev.mongmeo.proxyexample.decorator;

public class HelloRepositoryComponent extends Component{

  @Override
  public Object execute(Object... args) throws Exception {
    Thread.sleep(1000);
    return "hello";
  }
}
