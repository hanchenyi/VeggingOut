package com.example.demo.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class MyEnvironmentPostProcessor  implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try (InputStream input = new FileInputStream("xxx/Documents/projects/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            PropertiesPropertySource propertySource = new PropertiesPropertySource("ve", properties);
            environment.getPropertySources().addLast(propertySource);
            System.out.println("load external config files");
            application.setAllowBeanDefinitionOverriding(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}