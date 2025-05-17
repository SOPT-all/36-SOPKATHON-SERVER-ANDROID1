package org.sopt.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.OrderEntity;
import org.sopt.sopkathon.domain.ProductEntity;
import org.sopt.sopkathon.domain.UserEntity;
import org.sopt.sopkathon.dto.response.CreateOrderDto;
import org.sopt.sopkathon.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public CreateOrderDto createOrder(UserEntity user, ProductEntity product, int quantity) {
        int orderPrice = product.getPrice() * quantity;

        OrderEntity orderEntity = OrderEntity.builder()
                .user(user)
                .product(product)
                .quentity(quantity)
                .orderPrice(orderPrice)
                .build();

        OrderEntity order = orderRepository.save(orderEntity);

        int totalOrderPrice = orderRepository.getTotalOrderPriceByUserId(user.getId());
        user.updateLevelByTotalPrice(totalOrderPrice);

        return CreateOrderDto.of(order.getId(), totalOrderPrice);
    }
}
