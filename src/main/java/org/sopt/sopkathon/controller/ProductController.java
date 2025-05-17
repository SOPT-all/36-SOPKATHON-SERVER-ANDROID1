package org.sopt.sopkathon.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.dto.response.ProductDetailDto;
import org.sopt.sopkathon.global.result.ResultCode;
import org.sopt.sopkathon.global.result.ResultResponse;
import org.sopt.sopkathon.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResultResponse<ProductDetailDto> getProductDetail(
            @PathVariable Long productId
    ) {
        ProductDetailDto dto = productService.getProductDetail(productId);
        return ResultResponse.of(ResultCode.SUCCESS, dto);
    }

}
