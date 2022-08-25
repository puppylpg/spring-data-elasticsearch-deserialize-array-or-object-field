package io.puppylpg.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author puppylpg on 2022/07/27
 */
@Slf4j
@Configuration
public class Config {

    @Bean
    public RestClientBuilderCustomizer keepalive() {
        return new RestClientBuilderCustomizer() {
            @Override
            public void customize(RestClientBuilder builder) {

            }

            @Override
            public void customize(HttpAsyncClientBuilder builder) {
                // enable keep alive
                // ref: https://github.com/elastic/elasticsearch/issues/65213
                builder.setDefaultIOReactorConfig(IOReactorConfig.custom().setSoKeepAlive(true).build());
                log.info("es tcp keep-alive must be enabled!");
            }
        };
    }
}
