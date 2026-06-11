package com.rogerio.counter_scope.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterBean {

  private int count;

  public int increment() {
    return ++count;
  }
}
