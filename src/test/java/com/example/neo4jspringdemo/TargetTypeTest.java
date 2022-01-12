package com.example.neo4jspringdemo;

import com.example.neo4jspringdemo.entity.TargetType;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@SpringBootTest
public class TargetTypeTest {

    public static void main(String[] args) {
        Long l = System.currentTimeMillis();
        System.out.println(l >>16);
    }

    @Resource
    private TargetTypeRepository targetTypeRepository;

    @Test
    public void add(){
        for (EnumTargetType targetType : EnumTargetType.values()) {
            TargetType type =
                    new TargetType().setTargetType(targetType.getCode()).setName(targetType.getMsg());
            targetTypeRepository.save(type);
        }
    }

}
