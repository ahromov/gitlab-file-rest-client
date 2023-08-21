package com.example.demo.controller;

import com.example.demo.service.impl.GitServiceImpl;
import com.example.demo.service.dto.FileEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitController {

    private final GitServiceImpl gitServiceImpl;

    @Autowired
    public GitController(GitServiceImpl gitServiceImpl) {
        this.gitServiceImpl = gitServiceImpl;
    }

    @GetMapping("/file")
    public FileEntityDto getFile(@RequestParam("file_name") @NonNull String string) {
        return gitServiceImpl.getFile(string).getBody();
    }

}
