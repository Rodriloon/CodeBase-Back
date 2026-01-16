package CodeBase.demo.mapper;

import CodeBase.demo.dto.UserDTO;
import CodeBase.demo.dto.field.FieldDTO;
import CodeBase.demo.dto.field.FieldResponseDTO;
import CodeBase.demo.model.Field;
import CodeBase.demo.model.User;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(UserDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .image_url(dto.getImage_url())
                .phoneNumber(dto.getPhoneNumber())
                .role(dto.getRole())
                .build();
    }

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