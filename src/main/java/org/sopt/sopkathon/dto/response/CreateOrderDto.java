package org.sopt.sopkathon.dto.response;

public record CreateOrderDto(
        long orderId,
        int totalPrice
) {
    public static CreateOrderDto of(long orderId, int totalPrice) {
        return new CreateOrderDto(orderId, totalPrice);
    }
}
