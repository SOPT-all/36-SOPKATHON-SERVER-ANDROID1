package org.sopt.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.Category;
import org.sopt.sopkathon.domain.ProductEntity;
import org.sopt.sopkathon.dto.response.ProductDetailDto;
import org.sopt.sopkathon.dto.response.ProductInfoListDto;
import org.sopt.sopkathon.global.error.ErrorCode;
import org.sopt.sopkathon.global.error.exception.BusinessException;
import org.sopt.sopkathon.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDetailDto getProductDetail(Long productId) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NO_SUCH_PRODUCT_ERROR));
        return ProductDetailDto.of(product);
    }

    @Transactional(readOnly = true)
    public ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NO_SUCH_PRODUCT_ERROR));
    }

    public ProductInfoListDto getProductListByCategory(String categoryName){
        Category category = Category.from(categoryName);

        return ProductInfoListDto.from(productRepository.findAllByCategory(category));
    }

}
