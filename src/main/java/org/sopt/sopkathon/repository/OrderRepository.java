package org.sopt.sopkathon.repository;

import org.sopt.sopkathon.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}