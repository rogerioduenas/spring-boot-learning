package com.rogerio.restful;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FooService {

  public List<Foo> findAll() {
    List<Foo> list = new ArrayList<>();
    list.add(new Foo(1L, "Sample Foo"));
    return list;
  }

  public Foo findById(Long id) {
    return (id == 1L) ? new Foo(1L, "Sample Foo") : null;
  }

  public Long create(Foo resource) {
    return 100L; // Mock ID
  }

  public void update(Foo resource) {}
  public void deleteById(Long id) {}
}
