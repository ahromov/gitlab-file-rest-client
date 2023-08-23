package com.example.demo.util;

import lombok.experimental.UtilityClass;

import java.net.URI;

import static com.example.demo.util.UrlConstants.getString;

@UtilityClass
public class UriUtil {

    public URI getUri(String projectUrl, String fileName) {
        return URI.create(getString(projectUrl, fileName));
    }

}
