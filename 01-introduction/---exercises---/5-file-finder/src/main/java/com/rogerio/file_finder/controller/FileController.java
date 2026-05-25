package com.rogerio.file_finder.controller;

import com.rogerio.file_finder.dto.FileSearchResponseDTO;
import com.rogerio.file_finder.service.FileSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController {

  private final FileSearchService fileSearchService;

  public FileController(FileSearchService fileSearchService) {
    this.fileSearchService = fileSearchService;
  }

  @GetMapping(value = { "/{fileName}", "/{fileName}/{fileExtension}" })
  public ResponseEntity<FileSearchResponseDTO> getFile(@PathVariable String fileName, @PathVariable(required = false) String fileExtension) {
    FileSearchResponseDTO fileSearchResponseDTO = fileSearchService.getFile(fileName, fileExtension);
    return ResponseEntity.ok(fileSearchResponseDTO);
  }
}
