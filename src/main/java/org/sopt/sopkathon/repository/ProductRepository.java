package org.sopt.sopkathon.repository;

import org.sopt.sopkathon.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}