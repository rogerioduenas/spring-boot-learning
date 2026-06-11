package com.rogerio.counter_scope.controller;

import com.rogerio.counter_scope.component.CounterBean;
import com.rogerio.counter_scope.dto.CounterResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class counterController {

  private final CounterBean counterBean;

  public counterController(CounterBean counterBean) {
    this.counterBean = counterBean;
  }

  @PostMapping("/click")
  public ResponseEntity<CounterResponseDTO> click() {
    int count = counterBean.increment();
    return ResponseEntity.ok(new CounterResponseDTO(count));
  }
}
