package org.sopt.sopkathon.domain;

import lombok.Getter;

@Getter
public enum Level {

    NOVI("노비", 0),
    COMMONS("평민", 1),
    NOBILITY("귀족", 2),
    PRINCESS("공주", 3);

    private String name;
    private int level;

    Level(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
