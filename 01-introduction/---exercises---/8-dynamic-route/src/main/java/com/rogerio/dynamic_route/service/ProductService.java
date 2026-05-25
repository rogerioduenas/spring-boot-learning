package com.rogerio.dynamic_route.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

  public Map<String, String> processProductPath(Map<String, String> pathVariables) {
    return pathVariables;
  }
}
