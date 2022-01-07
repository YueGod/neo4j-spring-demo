package com.example.neo4jspringdemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.*;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@RelationshipEntity
@Data
@Accessors(chain = true)
public class TargetTypeRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private TargetType fromType;

    @EndNode
    private TargetType toType;

    @Property
    private Boolean direct;

    @Property
    private Boolean parent;
}
