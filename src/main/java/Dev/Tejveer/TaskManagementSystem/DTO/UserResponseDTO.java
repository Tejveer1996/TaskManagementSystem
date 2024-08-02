package Dev.Tejveer.TaskManagementSystem.DTO;

import Dev.Tejveer.TaskManagementSystem.Entity.Roles;
import Dev.Tejveer.TaskManagementSystem.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String username;
    private String email;
    private List<Roles> roles;
    private String token;

    public static UserResponseDTO from(User user){
        if (user == null){
            return null;
        }
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.username = user.getUsername();
        userResponseDTO.email = user.getEmailId();
        userResponseDTO.roles = new ArrayList<>();
        userResponseDTO.roles.addAll(user.getRoles());
        userResponseDTO.token = user.getToken();

        return userResponseDTO;

    }
}
