package io.puppylpg.data.repository;

import io.puppylpg.data.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author puppylpg on 2022/07/29
 */
@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}
