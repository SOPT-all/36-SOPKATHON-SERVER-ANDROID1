package org.sopt.sopkathon.dto.response;

import org.sopt.sopkathon.domain.ProductEntity;
import org.sopt.sopkathon.domain.Region;

public record ProductDetailDto(
        Long id,
        String image,
        String title,
        String feature,
        String flavor,
        String shape,
        String storage,
        String seller,
        Region region
) {
    public static ProductDetailDto of(ProductEntity product) {
        return new ProductDetailDto(
                product.getId(),
                product.getImageUrl(),
                product.getTitle(),
                product.getFeature(),
                product.getFlavor(),
                product.getShape(),
                product.getStorage(),
                product.getSeller(),
                product.getRegion()
        );
    }
}
