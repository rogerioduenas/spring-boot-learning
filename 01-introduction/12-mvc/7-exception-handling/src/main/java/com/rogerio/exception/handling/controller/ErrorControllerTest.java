package com.rogerio.exception.handling.controller;

import com.rogerio.exception.handling.entity.CustomExceptionObject;
import com.rogerio.exception.handling.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/error-test")
public class ErrorControllerTest {

  @GetMapping("/1")
  public void triggerError1() {
    throw new CustomException1("CustomException1");
  }

  @GetMapping("/2")
  public void triggerError2() {
    throw new CustomException2("CustomException2");
  }

  @GetMapping("/3")
  public void triggerError3() {
    throw new CustomException3("CustomException3");
  }

  @GetMapping("/4")
  public void triggerError4() {
    throw new CustomException4("CustomException4");
  }

  @GetMapping("/5")
  public void triggerError5() {
    throw new CustomException5("CustomException5");
  }

  // local handler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(CustomException6.class)
  public String handleException6(CustomException6 e) {
    return e.getMessage();
  }
  @GetMapping("/6")
  public void triggerError6() {
    throw new CustomException6("CustomException6");
  }

  @PostMapping("/7")
  public String triggerError7(@RequestBody CustomExceptionObject body) {
    return "Data received successfully.";
  }


  @GetMapping("/8")
  public void triggerError8() {
    throw new CustomException8("ID does not exist");
  }
}
