package com.example.neo4jspringdemo;

import com.example.neo4jspringdemo.entity.TargetType;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRelationRepository;
import com.example.neo4jspringdemo.reposiroty.TargetTypeRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        System.out.println(list);
        System.out.println(targetTypeRelationRepository.shortestPath(5, 3, false, list));
    }

    @Test
    public void test2() {
        List<Integer> flag = new ArrayList<>();
        List<Queue<Integer>> router = new ArrayList<>();
        LinkedList<Integer> routers;
        do {
            routers = targetTypeRelationRepository
                    .shortestPath(5, 3, false, flag)
                    .stream()
                    .map(TargetType::getTargetType)
                    .filter(ObjectUtils::isNotEmpty)
                    .collect(Collectors.toCollection(LinkedList::new));
            if (!routers.isEmpty()) {
                router.add(routers);
                routers.forEach(x -> {
                    if (!(x == 5 || x == 3)) {
                        flag.add(x);
                    }
                });
            }
        } while (!routers.isEmpty());

        System.out.println(router);

    }

    @Test
    public void test3() {
        System.out.println(targetTypeRelationRepository.findParent(5)
                .stream()
                .map(TargetType::getTargetType)
                .filter(e -> e != 5)
                .collect(Collectors.toList()));
    }

}
