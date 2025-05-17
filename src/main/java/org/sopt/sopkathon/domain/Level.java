package org.sopt.sopkathon.domain;

import lombok.Getter;

@Getter
public enum Level {

    NOVI("노비", 0, 100_000),
    COMMONS("평민", 1, 300_000),
    NOBILITY("귀족", 2, 500_000),
    PRINCESS("공주", 3, 500_000);

    private String name;
    private int level;
    private int maxPrice;

    Level(String name, int level, int maxPrice) {
        this.name = name;
        this.level = level;
        this.maxPrice = maxPrice;
    }
}
