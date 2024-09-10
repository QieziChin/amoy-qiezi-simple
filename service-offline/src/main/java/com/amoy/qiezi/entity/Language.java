package com.amoy.qiezi.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;

    private String drive;
    private String language;
    private String target;
    private int code;
}
