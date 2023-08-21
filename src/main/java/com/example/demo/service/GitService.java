package com.example.demo.service;

import com.example.demo.service.dto.FileEntityDto;
import org.springframework.http.ResponseEntity;

public interface GitService {

    ResponseEntity<FileEntityDto> getFile(String fileName);

}
