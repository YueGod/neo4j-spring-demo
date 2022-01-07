package com.example.neo4jspringdemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@NodeEntity
@Data
@Accessors(chain = true)
public class TargetType {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private Integer targetType;

    @Property
    private String name;

}
