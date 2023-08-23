package com.example.demo.util;

import lombok.experimental.UtilityClass;


@UtilityClass
public class UrlConstants {

    static final String REF_DEV = "?ref=dev";

    public static String getString(String projectUrl, String filename) {
        return projectUrl
                + getReplaced(filename)
                + REF_DEV;
    }

    private static String getReplaced(String filename) {
        return filename
                .replace(".", "%2E")
                .replace(" ", "%20")
                .replace("/", "%2F");
    }

}
