package com.rogerio.custom.error;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

  @NotBlank(message = "This field can't be empty")
  private String name;
  @Min(value = 18, message = "Age can be over 18")
  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
