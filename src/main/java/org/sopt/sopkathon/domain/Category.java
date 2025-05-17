package org.sopt.sopkathon.domain;

import org.sopt.sopkathon.global.error.ErrorCode;
import org.sopt.sopkathon.global.error.exception.BusinessException;

public enum Category {
    // 채소
    CHILI("고추"),
    WATERMELON("수박"),
    SHIITAKE("표고"),
    GARLIC("마늘"),

    // 과일
    APPLE("사과"),
    STRAWBERRY("딸기"),
    CHESTNUT("알밤"),
    MELON("메론"),

    // 곡물
    RICE("쌀");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public static Category from(String name){
        for(Category category : values()){
            if(category.description.equals(name)){
                return category;
            }
        }
        throw new BusinessException(ErrorCode.NO_SUCH_CATEGORY_ERROR);
    }
}
