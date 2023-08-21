package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class Config {

    @Value("${base_url}")
    private String baseUrl;

    @Value("${project_id}")
    private String projectId;

    @Value("${token}")
    private String privateToken;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public <T> HttpEntity<T> getHttpEntity() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", privateToken);
        return new HttpEntity<>(headers);
    }

    @Bean
    public String getUrl() {
        return baseUrl + "/projects/" + projectId + "/repository/files/";
    }

}
