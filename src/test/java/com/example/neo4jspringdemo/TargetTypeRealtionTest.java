package com.example.neo4jspringdemo;

import com.example.neo4jspringdemo.entity.TargetType;
import com.example.neo4jspringdemo.entity.TargetTypeRelation;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRelationRepository;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@SpringBootTest
public class TargetTypeRealtionTest {

    @Resource
    private TargetTypeRepository targetTypeRepository;

    @Resource
    private TargetTypeRelationRepository targetTypeRelationRepository;

    @Test
    public void add(){
        store();
        college();
        supplier_agent();
        supplier();
        team();
    }

    /**
     * 美店
     */
    public void store(){
        TargetType store = targetTypeRepository.findByTargetType(EnumTargetType.store.getCode());

        TargetType targetType = targetTypeRepository.findByTargetType(EnumTargetType.supplier_agent.getCode());
        TargetType targetType2 = targetTypeRepository.findByTargetType(EnumTargetType.team.getCode());
        TargetType targetType3 = targetTypeRepository.findByTargetType(EnumTargetType.college.getCode());
        TargetType targetType4 = targetTypeRepository.findByTargetType(EnumTargetType.supplier.getCode());

        List<TargetTypeRelation> list = new ArrayList<>();

        list.add(new TargetTypeRelation().setFromType(store).setToType(targetType).setParent(true).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(store).setToType(targetType2).setParent(true).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(store).setToType(targetType3).setParent(true).setDirect(true));
        list.add(new TargetTypeRelation().setFromType(store).setToType(targetType4).setParent(true).setDirect(true));

        targetTypeRelationRepository.saveAll(list);
    }

    /**
     * 美学院
     */
    public void college(){
        TargetType college = targetTypeRepository.findByTargetType(EnumTargetType.college.getCode());

        TargetType targetType = targetTypeRepository.findByTargetType(EnumTargetType.team.getCode());
        TargetType targetType2 = targetTypeRepository.findByTargetType(EnumTargetType.store.getCode());

        List<TargetTypeRelation> list = new ArrayList<>();

        list.add(new TargetTypeRelation().setFromType(college).setToType(targetType).setParent(false).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(college).setToType(targetType2).setParent(false).setDirect(true));

        targetTypeRelationRepository.saveAll(list);
    }


    /**
     * fn
     */
    public void supplier_agent() {
        TargetType supplier_agent = targetTypeRepository.findByTargetType(EnumTargetType.supplier_agent.getCode());

        TargetType targetType = targetTypeRepository.findByTargetType(EnumTargetType.college.getCode());
        TargetType targetType2 = targetTypeRepository.findByTargetType(EnumTargetType.supplier.getCode());
        TargetType targetType3 = targetTypeRepository.findByTargetType(EnumTargetType.store.getCode());

        List<TargetTypeRelation> list = new ArrayList<>();

        list.add(new TargetTypeRelation().setFromType(supplier_agent).setToType(targetType).setParent(true).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(supplier_agent).setToType(targetType2).setParent(true).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(supplier_agent).setToType(targetType3).setParent(false).setDirect(false));

        targetTypeRelationRepository.saveAll(list);
    }

    public void team() {
        TargetType team = targetTypeRepository.findByTargetType(EnumTargetType.team.getCode());

        TargetType targetType = targetTypeRepository.findByTargetType(EnumTargetType.college.getCode());
        TargetType targetType3 = targetTypeRepository.findByTargetType(EnumTargetType.store.getCode());

        List<TargetTypeRelation> list = new ArrayList<>();

        list.add(new TargetTypeRelation().setFromType(team).setToType(targetType).setParent(true).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(team).setToType(targetType3).setParent(false).setDirect(false));

        targetTypeRelationRepository.saveAll(list);
    }

    public void supplier() {
        TargetType supplier = targetTypeRepository.findByTargetType(EnumTargetType.supplier.getCode());

        TargetType targetType = targetTypeRepository.findByTargetType(EnumTargetType.supplier_agent.getCode());
        TargetType targetType3 = targetTypeRepository.findByTargetType(EnumTargetType.store.getCode());

        List<TargetTypeRelation> list = new ArrayList<>();

        list.add(new TargetTypeRelation().setFromType(supplier).setToType(targetType).setParent(false).setDirect(false));
        list.add(new TargetTypeRelation().setFromType(supplier).setToType(targetType3).setParent(false).setDirect(true));

        targetTypeRelationRepository.saveAll(list);
    }

}
