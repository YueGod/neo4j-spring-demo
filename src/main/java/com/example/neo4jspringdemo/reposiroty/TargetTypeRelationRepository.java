package com.example.neo4jspringdemo.reposiroty;

import com.example.neo4jspringdemo.entity.TargetType;
import com.example.neo4jspringdemo.entity.TargetTypeRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@Repository
public interface TargetTypeRelationRepository extends Neo4jRepository<TargetTypeRelation, Long> {

    @Query("MATCH (p1:TargetType {targetType: {fromType} }),(p2:TargetType {targetType: {toType} })," +
            "p=shortestPath((p1)-[r:TARGETTYPERELATION*]->(p2)) " +
            "WHERE ALL (x in r where x.direct = {direct}) AND NONE(x in nodes(p) where x.targetType IN {not})" +
            "RETURN p")
    List<TargetType> shortestPath(@Param("fromType") Integer fromType,
                                  @Param("toType") Integer toType,
                                  @Param("direct") Boolean direct,
                                  @Param("not") List<Integer> not);

    @Query("MATCH (p1:TargetType {targetType: {targetType}}),\n" +
            "p=(p1)-[r:TARGETTYPERELATION*]->()\n" +
            "WHERE ALL (x in r where x.parent=true)\n" +
            "RETURN p")
    List<TargetType> findParent(@Param("targetType") Integer targetType);

    @Query("MATCH (p1:TargetType {targetType: {targetType}}),\n" +
            "p=(p1)-[r:TARGETTYPERELATION*]->()\n" +
            "WHERE ALL (x in r where x.parent=false)\n" +
            "RETURN p")
    List<TargetType> findchildren(@Param("targetType") Integer targetType);

}
