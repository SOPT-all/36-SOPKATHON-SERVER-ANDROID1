package org.sopt.sopkathon.domain;

import lombok.Getter;

@Getter
public enum Region {    // 시
    GONGJU("공주"),
    ASAN("아산"),
    CHEONAN("천안"),
    DANGJIN("당진"),
    SEOSAN("서산"),
    BORYEONG("보령"),
    GYERYONG("계룡"),
    NONSAN("논산"),

    // 군
    TAEAN("태안"),
    HONGSEONG("홍성"),
    YESAN("예산"),
    CHEONGYANG("청양"),
    BUYEO("부여"),
    SEOCHEON("서천"),
    GEUMSAN("금산");


    private final String description;

    Region(String description) {
        this.description = description;
    }
}
