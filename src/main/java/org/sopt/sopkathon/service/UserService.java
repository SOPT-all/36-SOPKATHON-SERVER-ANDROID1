package org.sopt.sopkathon.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.UserEntity;
import org.sopt.sopkathon.dto.response.UserInfoDto;
import org.sopt.sopkathon.global.error.exception.NoSuchUserException;
import org.sopt.sopkathon.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;


    public UserInfoDto getUserInfo(Long userId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(NoSuchUserException::new);

        return UserInfoDto.from(user);
    }

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(NoSuchUserException::new);
    }
}
