package com.rogerio.pagination;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

  private final List<UserDTO> simulateDB = List.of(
      new UserDTO("User 1"), new UserDTO("User 2"), new UserDTO("User 3"),
      new UserDTO("User 4"), new UserDTO("User 5")
  );

  @GetMapping
  public ResponseEntity<List<UserDTO>> findPaginated(
      @RequestParam("page") int page,
      @RequestParam("size") int size) {

    int start = page * size;
    int end = Math.min((start + size), simulateDB.size());

    if (start >= simulateDB.size() || start < 0) {
      return ResponseEntity.ok(List.of());
    }

    List<UserDTO> pageResult = simulateDB.subList(start, end);

    return ResponseEntity.ok(pageResult);
  }
}
