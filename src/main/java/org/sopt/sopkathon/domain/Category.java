package org.sopt.sopkathon.domain;

import org.sopt.sopkathon.global.error.ErrorCode;
import org.sopt.sopkathon.global.error.exception.BusinessException;

public enum Category {
    STRAWBERRY("딸기");

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
