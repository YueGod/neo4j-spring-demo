package com.example.neo4jspringdemo;

import com.example.neo4jspringdemo.reposiroty.TargetTypeRelationRepository;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRepository;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@SpringBootTest
public class SearchTest {

    @Resource
    private TargetTypeRepository targetTypeRepository;

    @Resource
    private TargetTypeRelationRepository targetTypeRelationRepository;


}
