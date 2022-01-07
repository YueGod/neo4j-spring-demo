package com.example.neo4jspringdemo;

import lombok.Getter;

/**
 * @author YueGod
 * @since 2022/1/6
 */
@Getter
public enum EnumTargetType {
    lsk(0, "联商客"),
    supplier(1, "生产厂"),
    supplier_agent(2, "代理商"),
    college(3, "美学院"),
    castellan(4, "城主群主"),
    store(5, "美店"),
    employee(6, "美咖"),
    team(7, "营销商"),
    user(10, "普通用户");

    private final Integer code;
    private final String msg;

    EnumTargetType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}