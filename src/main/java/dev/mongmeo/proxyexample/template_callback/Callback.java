package dev.mongmeo.proxyexample.template_callback;

public interface Callback {

  Object execute(Object... args) throws Exception;
}
