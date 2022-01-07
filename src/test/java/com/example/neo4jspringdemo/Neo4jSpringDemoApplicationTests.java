package com.example.neo4jspringdemo;

import com.example.neo4jspringdemo.entity.TargetType;
import com.example.neo4jspringdemo.entity.TargetTypeRelation;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRelationRepository;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootTest
class Neo4jSpringDemoApplicationTests {

    @Resource
    private TargetTypeRepository targetTypeRepository;
    @Resource
    private TargetTypeRelationRepository targetTypeRelationRepository;

    @Test
    void contextLoads() {
        System.out.println(targetTypeRepository.findAll());

        System.out.println(targetTypeRelationRepository.findAll());
    }

    @Test
    void add(){
        //添加机构类型
        TargetType store = new TargetType().setTargetType(5).setName("美店");
        TargetType agent = new TargetType().setTargetType(2).setName("供应商");
        TargetType team = new TargetType().setTargetType(7).setName("营销商");
        targetTypeRepository.saveAll(Arrays.asList(store,agent,team));

        //添加机构之间的关系
        TargetTypeRelation relation = new TargetTypeRelation()
                .setDirect(false)
                .setFromType(store)
                .setToType(agent)
                .setParent(false);

        TargetTypeRelation relation2 = new TargetTypeRelation()
                .setDirect(false)
                .setFromType(store)
                .setToType(team)
                .setParent(false);

        targetTypeRelationRepository.saveAll(Arrays.asList(relation,relation2));

        System.out.println(targetTypeRepository.findAll());

        System.out.println(targetTypeRelationRepository.findAll());
    }

}
