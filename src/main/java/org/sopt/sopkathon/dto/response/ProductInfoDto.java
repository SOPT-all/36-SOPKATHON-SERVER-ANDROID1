package org.sopt.sopkathon.dto.response;

import org.sopt.sopkathon.domain.ProductEntity;

public record ProductInfoDto(Long id, String title, String image, String region, int price) {

    public static ProductInfoDto from(ProductEntity product){
        return new ProductInfoDto(
                product.getId(),
                product.getTitle(),
                product.getImageUrl(),
                product.getRegion().getDescription(),
                product.getPrice()
                );
    }
}
