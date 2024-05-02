package br.com.leadersofts.qikserve.infrastructure.products.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class QikServeConfiguration {

    @Value("${qikserve.api.url}")
    private String host;

    @Value("${qikserve.api.scheme}")
    String scheme;

    @Value("${qikserve.api.path}")
    String path;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UriComponents uriComponents() {
        return UriComponentsBuilder.newInstance()
                .host(host)
                .scheme(scheme)
                .path(path)
                .build();
    }

}
