package io.puppylpg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author puppylpg on 2022/07/26
 */
@Slf4j
@EnableElasticsearchRepositories(basePackages = "io.puppylpg.data.repository")
@SpringBootApplication
public class App {

    private final PersonOps personOps;

    public App(PersonOps personOps) {
        this.personOps = personOps;
    }

    /**
     * run `insert.txt` before execute
     */
    public static void main(String[] args) {
        App app = SpringApplication.run(App.class, args).getBean(App.class);

        app.personOps.get("one-hobby");
        app.personOps.get("two-hobbies");
        app.personOps.get("one-child");
        app.personOps.get("two-children");

        System.exit(0);
    }


}
