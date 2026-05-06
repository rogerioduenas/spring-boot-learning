package com.rogerio.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/foos")
public class FooController {

  @Autowired
  private FooService service;

  @GetMapping
  public List<Foo> findAll() {
    return service.findAll();
  }

  @GetMapping(value = "/{id}")
  public Foo findById(@PathVariable("id") Long id) {
    Foo foo = service.findById(id);
    if (foo == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo not found");
    }
    return foo;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long create(@RequestBody Foo resource) {
    if (resource == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Resource is null");
    }
    return service.create(resource);
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable("id") Long id, @RequestBody Foo resource) {
    if (resource == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required");
    }

    if (!Objects.equals(resource.getId(), id)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID in body does not match ID in URL");
    }

    service.update(resource);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Long id) {
    service.deleteById(id);
  }
}