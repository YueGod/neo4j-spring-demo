package com.example.neo4jspringdemo.entity;

import lombok.Data;

/**
 * @author YueGod
 * @since 2022/1/11
 */
@Data
public class ShortestPath {
    private TargetType targetType;

    private TargetTypeRelation targetTypeRelation;
}
