package org.sopt.sopkathon.repository;

import org.sopt.sopkathon.domain.Category;
import org.sopt.sopkathon.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByCategory(Category category);
}
