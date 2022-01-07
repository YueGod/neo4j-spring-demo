package com.example.neo4jspringdemo.reposiroty;

import com.example.neo4jspringdemo.entity.TargetTypeRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@Repository
public interface TargetTypeRelationRepository extends Neo4jRepository<TargetTypeRelation,Long> {
}
