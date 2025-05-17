package org.sopt.sopkathon.dto.request;

import org.sopt.sopkathon.domain.ProductEntity;

public record OrderRequestDto(
        Long userId,
        Long productId,
        int quantity
) {
    public static OrderRequestDto from(Long userId, ProductEntity product, int quantity) {
        return new OrderRequestDto(
                userId,
                product.getId(),
                quantity
        );
    }
}
