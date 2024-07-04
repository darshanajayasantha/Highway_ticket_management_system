package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.UserDto;
import lk.ijse.user_service.entity.User;
import lk.ijse.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        User user =User.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();

        userRepository.save(user);
    }

    public boolean checkCredentials(UserDto userDto) {
        return userRepository.existsByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
    }

    public boolean isExistsUser(String userId) {
        return userRepository.existsById(userId);
    }
}
