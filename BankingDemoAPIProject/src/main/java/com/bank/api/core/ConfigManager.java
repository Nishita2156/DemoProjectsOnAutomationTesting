package com.bank.api.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ConfigManager {
    private static final Env ENV;

    static {
        try {
            File file = Paths.get("src/test/resources/config/env.yaml").toFile();
            ENV = new ObjectMapper(new YAMLFactory()).readValue(file, Env.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load env.yaml", e);
        }
    }

    public static Env env() {
        return ENV;
    }
}
