package org.sopt.sopkathon.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.dto.response.ProductDetailDto;
import org.sopt.sopkathon.dto.response.ProductInfoListDto;
import org.sopt.sopkathon.global.result.ResultCode;
import org.sopt.sopkathon.global.result.ResultResponse;
import org.sopt.sopkathon.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ResultResponse<ProductDetailDto>> getProductDetail(
            @PathVariable Long productId
    ) {
        ProductDetailDto dto = productService.getProductDetail(productId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.SUCCESS, dto));
    }

    @GetMapping
    public ResponseEntity<ResultResponse<ProductInfoListDto>> getProductList(@RequestParam(name = "category") String category){
        return ResponseEntity.ok(ResultResponse.of(ResultCode.SUCCESS, productService.getProductListByCategory(category)));
    }

}
