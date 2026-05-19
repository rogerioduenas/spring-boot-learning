package com.rogerio.custom.error;

import org.jspecify.annotations.Nullable;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    List<String> errors = new ArrayList<>();

    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.add(error.getField() + ": " + error.getDefaultMessage());
    }

    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
      errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    }

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

    return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
  }

  @Override
  protected @Nullable ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    String error = ex.getParameterName() + " parameter is missing";

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "My custom message", error);

    return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
  }

  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
      MethodArgumentTypeMismatchException ex,
      WebRequest request) {

    String error = String.format("The variable named '%s' should be of type %s", ex.getName().toUpperCase(), ex.getRequiredType().getName());

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), error);

    return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
  }

  @Override
  protected @Nullable ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    StringBuilder builder = new StringBuilder();
    builder.append(ex.getMethod());
    builder.append(" method is not supported in this request. Supported methods are: ");
    ex.getSupportedHttpMethods().forEach(method -> builder.append(method).append(" "));
    ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, "My personal error message", builder.toString());

    return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
  }

  @Override
  protected @Nullable ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    String supportedTypes = ex.getSupportedMediaTypes().stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    String error = String.format("%s media type is not supported. Supported media types are %s",
        ex.getContentType(), supportedTypes);

    ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Personal error message", error);

    return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleAll(Exception ex,
                                          WebRequest request) {
    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Aleatory unexpected error", "Error occurred");

    return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
  }
}
