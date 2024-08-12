package com.amoy.service.admin.emums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum AuthType {
    menu("menu", "menu"),
    file("file", "menu");

    @EnumValue
    private final String value;

    @JsonValue
    private final String desc;

    AuthType(String value, String desc){
        this.value = value;
        this.desc = desc;
    }
}
