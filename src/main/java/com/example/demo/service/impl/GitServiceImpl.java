package com.example.demo.service.impl;

import com.example.demo.service.GitService;
import com.example.demo.service.dto.FileEntityDto;
import com.example.demo.util.UriUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class GitServiceImpl implements GitService {

    private final RestTemplate restTemplate;

    private final HttpEntity<FileEntityDto> httpEntity;

    private final String url;

    public GitServiceImpl(RestTemplate restTemplate, HttpEntity<FileEntityDto> httpEntity, String url) {
        this.restTemplate = restTemplate;
        this.httpEntity = httpEntity;
        this.url = url;
    }

    @Override
    public ResponseEntity<FileEntityDto> getFile(String fileName) {
        URI uri = UriUtil.getUri(url, fileName);
        log.info("{}", uri);
        return getResEntityResponseEntity(uri);
    }

    private ResponseEntity<FileEntityDto> getResEntityResponseEntity(URI uri) {
        ResponseEntity<FileEntityDto> exchange = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, FileEntityDto.class);
        log.info("{}", exchange);
        return exchange;
    }

}
