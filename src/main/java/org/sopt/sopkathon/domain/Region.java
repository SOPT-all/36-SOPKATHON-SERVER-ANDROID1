package org.sopt.sopkathon.domain;

import lombok.Getter;

@Getter
public enum Region {    // 시
    GONGJU("공주시"),
    ASAN("아산시"),
    CHEONAN("천안시"),
    DANGJIN("당진시"),
    SEOSAN("서산시"),
    BORYEONG("보령시"),
    GYERYONG("계룡시"),
    NONSAN("논산시"),

    // 군
    TAEAN("태안군"),
    HONGSEONG("홍성군"),
    YESAN("예산군"),
    CHEONGYANG("청양군"),
    BUYEO("부여군"),
    SEOCHEON("서천군"),
    GEUMSAN("금산군");


    private final String description;

    Region(String description) {
        this.description = description;
    }
}
