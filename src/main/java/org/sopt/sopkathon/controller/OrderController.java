package org.sopt.sopkathon.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.dto.request.OrderRequestDto;
import org.sopt.sopkathon.dto.response.OrderResponseDto;
import org.sopt.sopkathon.facade.OrderFacade;
import org.sopt.sopkathon.global.result.ResultCode;
import org.sopt.sopkathon.global.result.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderFacade orderFacade;

    @PostMapping
    public ResponseEntity<ResultResponse<OrderResponseDto>> createOrder(
            @RequestBody OrderRequestDto dto
    ) {
        OrderResponseDto responseDto = orderFacade.createOrder(dto);
        return ResponseEntity.status(ResultCode.CREATED.getStatus())
                .body(ResultResponse.of(ResultCode.CREATED, responseDto));
    }
}
