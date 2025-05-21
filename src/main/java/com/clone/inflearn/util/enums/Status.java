package com.clone.inflearn.util.enums;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("활성"),
    INACTIVE("비활성"),
    DELETED("삭제");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}
