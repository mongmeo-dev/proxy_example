package dev.mongmeo.proxyexample.strategy;

public interface Strategy {

  Object execute(Object... args) throws Exception;
}
