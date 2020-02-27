package ua.epam.springApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("ua.epam.springApp")
@Import(WebConfig.class)
public class AppConfig {
}
