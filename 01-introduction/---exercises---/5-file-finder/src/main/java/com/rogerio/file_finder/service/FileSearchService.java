package com.rogerio.file_finder.service;

import com.rogerio.file_finder.dto.FileSearchResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class FileSearchService {

  public FileSearchResponseDTO getFile(String fileName, String fileExtension ) {
    if (fileExtension != null) {
      return new FileSearchResponseDTO(String.format("Searching for file %s.%s.", fileName, fileExtension));
    }
    return new FileSearchResponseDTO(String.format("Searching for file %s with standard extension .txt", fileName));
  }
}
