package org.sopt.sopkathon.dto.response;

public record OrderResponseDto(
        Long orderId
) {
    public static OrderResponseDto of(Long orderId) {
        return new OrderResponseDto(
                orderId
        );
    }
}
