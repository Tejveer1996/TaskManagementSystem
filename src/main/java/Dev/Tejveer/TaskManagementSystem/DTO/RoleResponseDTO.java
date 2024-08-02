package Dev.Tejveer.TaskManagementSystem.DTO;

import Dev.Tejveer.TaskManagementSystem.Entity.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDTO {
    private String role;
    private String desc;

    public static RoleResponseDTO from(Roles role){
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.role = role.getRoleName();
        responseDTO.desc = role.getDescription();
        return responseDTO;
    }
}
