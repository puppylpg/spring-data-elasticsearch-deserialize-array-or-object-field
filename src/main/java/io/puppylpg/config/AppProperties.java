package io.puppylpg.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author puppylpg on 2022/08/01
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private EsIndexes esIndexes;

    @PostConstruct
    public void init() {
        log.info("App properties config: {}", this);
    }

    @Data
    public static class EsIndexes {
        private String Person;
    }

}
