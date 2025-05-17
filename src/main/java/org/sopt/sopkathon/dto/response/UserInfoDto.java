package org.sopt.sopkathon.dto.response;

import org.sopt.sopkathon.domain.UserEntity;

public record UserInfoDto(Long id, String username, int totalPrice, int level, int maxPrice) {

    public static UserInfoDto from(UserEntity user) {
        return new UserInfoDto(
                user.getId(),
                user.getName(),
                user.getTotalPrice(),
                user.getLevel().getLevel(),
                user.getLevel().getMaxPrice()
        );
    }
}
