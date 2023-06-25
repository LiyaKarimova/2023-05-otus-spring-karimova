package ru.otus.homework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties (prefix = "question")
public class AppQuestionProperties {

    private final String bundleFileName;

    private final String regex;

    @ConstructorBinding
    public AppQuestionProperties(String bundleFileName, String regex) {
        this.bundleFileName = bundleFileName;
        this.regex = regex;
    }

    public String getBundleFileName() {
        return bundleFileName;
    }

    public String getRegex() {
        return regex;
    }
}
