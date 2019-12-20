package com.hk.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogQuery {
    private String title;
    private Long typeId;

    public BlogQuery() {
    }
}
