package CodeBase.demo.controller;

import CodeBase.demo.dto.UserDTO;
import CodeBase.demo.mapper.UserMapper;
import CodeBase.demo.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/me")
    public UserDTO me(@AuthenticationPrincipal User user) {
        return UserMapper.toDto(user);
    }
}

