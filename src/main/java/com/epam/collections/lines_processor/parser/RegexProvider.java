package com.epam.collections.lines_processor.parser;

import java.util.ResourceBundle;

public final class RegexProvider {
    private static RegexProvider regexProvider;
    private final static String REGULAR_FILE = "regular_expressions";

    public static String get(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(REGULAR_FILE);
        return resourceBundle.getString(key);
    }

    private RegexProvider() {

    }


}

