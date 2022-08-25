package io.puppylpg;

import io.puppylpg.data.entity.Person;
import io.puppylpg.data.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author puppylpg on 2022/08/19
 */
@Slf4j
@Component
public class PersonOps {

    private final PersonRepository personRepository;

    public PersonOps(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void get(String id) {
        Optional<Person> person = personRepository.findById(id);
        person.ifPresent(value -> log.info("get person={}", value));
    }
}
