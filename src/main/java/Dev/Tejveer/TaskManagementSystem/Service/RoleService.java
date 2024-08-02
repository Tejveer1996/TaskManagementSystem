package Dev.Tejveer.TaskManagementSystem.Service;

import Dev.Tejveer.TaskManagementSystem.DTO.RoleRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.RoleResponseDTO;

public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
}
