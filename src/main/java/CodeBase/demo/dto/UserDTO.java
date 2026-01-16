package CodeBase.demo.dto;

import CodeBase.demo.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String image_url;
    private String phoneNumber;
    private User.Role role;
}
