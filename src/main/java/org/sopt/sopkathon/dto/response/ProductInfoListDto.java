package org.sopt.sopkathon.dto.response;

import org.sopt.sopkathon.domain.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public record ProductInfoListDto(List<ProductInfoDto> info) {

    public static ProductInfoListDto from(List<ProductEntity> productList){
        return new ProductInfoListDto(productList.stream()
                .map(ProductInfoDto::from)
                .collect(Collectors.toList()));
    }
}
