package com.moriset.observability.config;

import org.springframework.context.MessageSource;
import org.springframework.web.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class BeansConfig {

    @Bean
    public RestClient getRestClient() {
        return RestClient.create("https://jsonplaceholder.typicode.com");
    }

    @Bean
    public MessageSource sourceAutoConfiguration() {
        var source = new ReloadableResourceBundleMessageSource();
        source.setBasename("bundle");
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}
