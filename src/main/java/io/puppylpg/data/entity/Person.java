package io.puppylpg.data.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import java.util.List;

/**
 * @author puppylpg on 2022/08/22
 */
@Data
@Builder
@Document(indexName = "#{@environment.getProperty('app.es-indexes.person')}", writeTypeHint = WriteTypeHint.FALSE, createIndex = true)
public class Person {

    @Id
    @ReadOnlyProperty
    private String id;

    @Field(type = FieldType.Keyword)
    private List<String> hobbies;

    @Field(type = FieldType.Object)
    private List<Child> children;

    @Data
    public static class Child {
        @Field(type = FieldType.Keyword)
        private String name;
    }
}
