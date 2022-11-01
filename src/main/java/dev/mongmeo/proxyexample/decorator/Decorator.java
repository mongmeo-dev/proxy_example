package dev.mongmeo.proxyexample.decorator;

public abstract class Decorator extends Component {

  private final Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  @Override
  public Object execute(Object... args) throws Exception {
    return component.execute();
  }
}
