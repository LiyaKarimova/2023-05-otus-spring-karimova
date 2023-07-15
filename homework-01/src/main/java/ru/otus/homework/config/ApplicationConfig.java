package ru.otus.homework.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({AppProperties.class, AppQuestionProperties.class})
public class ApplicationConfig {



}
