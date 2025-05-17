package org.sopt.sopkathon.facade;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.OrderEntity;
import org.sopt.sopkathon.domain.ProductEntity;
import org.sopt.sopkathon.domain.UserEntity;
import org.sopt.sopkathon.dto.request.OrderRequestDto;
import org.sopt.sopkathon.dto.response.OrderResponseDto;
import org.sopt.sopkathon.service.OrderService;
import org.sopt.sopkathon.service.ProductService;
import org.sopt.sopkathon.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto dto) {
        ProductEntity product = productService.getProduct(dto.productId());
        UserEntity user = userService.getUserById(dto.userId());
        OrderEntity order = orderService.createOrder(user, product, dto.quantity());
        return OrderResponseDto.from(order);
    }
}