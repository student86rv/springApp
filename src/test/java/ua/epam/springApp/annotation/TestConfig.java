package ua.epam.springApp.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ua.epam.springApp.postProcessor.TimedAnnotationBeanPostProcessor;

@Configuration
@ComponentScan({"ua.epam.springApp.repository", "ua.epam.springApp.postProcessor"})
public class TestConfig {

    @Bean
    public TimedAnnotationBeanPostProcessor timedAnnotationBeanPostProcessor() {
        return new TimedAnnotationBeanPostProcessor();
    }
}
