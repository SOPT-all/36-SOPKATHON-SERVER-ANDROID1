package org.sopt.sopkathon.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.dto.response.UserInfoDto;
import org.sopt.sopkathon.global.result.ResultCode;
import org.sopt.sopkathon.global.result.ResultResponse;
import org.sopt.sopkathon.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/{userId}")
    public ResponseEntity<ResultResponse<UserInfoDto>> getUser(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(ResultResponse.of(ResultCode.SUCCESS, userService.getUserInfo(userId)));
    }
}
