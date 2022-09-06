package com.coffeegit.springboot.jpamysql.model.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

	SUPERADMIN("Super Admin"),
    ADMIN("Administrator"),
    EDITOR("Editor"),
    AUTHOR("Author"),
    CONTRIBUTOR("Contributor"),
    SUBSCRIBER("Subscriber");

    private final String name;
    
    private RoleEnum(String name) {
        this.name = name;
    }

}
