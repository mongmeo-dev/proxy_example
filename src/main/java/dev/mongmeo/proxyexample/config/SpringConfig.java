package dev.mongmeo.proxyexample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "dev.mongmeo.proxyexample.aop")
@EnableAspectJAutoProxy
public class SpringConfig {
}
