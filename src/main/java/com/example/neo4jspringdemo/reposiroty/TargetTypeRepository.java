package com.example.neo4jspringdemo.reposiroty;

import com.example.neo4jspringdemo.entity.TargetType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@Repository
public interface TargetTypeRepository extends Neo4jRepository<TargetType,Long> {

    TargetType findByTargetType(Integer targetType);

}
