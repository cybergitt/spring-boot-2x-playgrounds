package com.coffeegit.springboot.jpamysql.model.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

	SUPERADMIN("SUPERADMIN"),
    ADMIN("ADMIN"),
    AGENT("AGENT");

    private String name;
    
    RoleEnum(String name) {
        this.name = name;
    }

}
