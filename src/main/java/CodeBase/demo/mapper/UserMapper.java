package CodeBase.demo.mapper;

import CodeBase.demo.dto.UserDTO;
import CodeBase.demo.model.User;

public class UserMapper {

    private UserMapper() {}

    public static UserDTO toDto(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .image_url(entity.getImage_url())
                .phoneNumber(entity.getPhoneNumber())
                .role(entity.getRole())
                .build();
    }
}