package org.sopt.sopkathon.dto.response;

import org.sopt.sopkathon.domain.OrderEntity;

public record OrderResponseDto(
        Long orderId
) {
    public static OrderResponseDto from(OrderEntity orderEntity) {
        return new OrderResponseDto(
                orderEntity.getId()
        );
    }
}
