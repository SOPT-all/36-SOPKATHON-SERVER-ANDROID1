package org.sopt.sopkathon.domain;

import lombok.Getter;

@Getter
public enum Region {
    GONGJOO("공주");

    private final String description;

    Region(String description) {
        this.description = description;
    }
}
