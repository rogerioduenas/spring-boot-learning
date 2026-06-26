package com.rogerio.persisting_enums;

public enum Category {
  SPORT("S"), MUSIC("M"), TECHNOLOGY("T");

  private String code;

  Category(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
