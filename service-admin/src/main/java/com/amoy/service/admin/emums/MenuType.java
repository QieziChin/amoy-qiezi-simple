package com.amoy.service.admin.emums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum MenuType {
    addtabs("addtabs", "addtabs"),
    blank("blank", "blank"),
    dialog("dialog", "dialog"),
    ajax("ajax", "ajax");

    @EnumValue
    private final String value;

    @JsonValue
    private final String desc;

    MenuType(String value, String desc){
        this.value = value;
        this.desc = desc;
    }
}
