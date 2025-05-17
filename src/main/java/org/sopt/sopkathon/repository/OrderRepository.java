package org.sopt.sopkathon.repository;

import org.sopt.sopkathon.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT SUM(o.orderPrice) FROM order_table o WHERE o.user.id = :userId")
    int getTotalOrderPriceByUserId(@Param("userId") Long userId);
}