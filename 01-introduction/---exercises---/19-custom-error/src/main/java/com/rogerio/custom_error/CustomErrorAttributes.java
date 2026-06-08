package com.rogerio.custom_error;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
    Map<String, Object> defaultAttributes = super.getErrorAttributes(webRequest, options);

    Map<String, Object> targetedAttributes = new LinkedHashMap<>();

    targetedAttributes.put("timestamp", defaultAttributes.get("timestamp"));
    targetedAttributes.put("status", defaultAttributes.get("status"));
    targetedAttributes.put("error", defaultAttributes.get("error"));

    return targetedAttributes;
  }
}
