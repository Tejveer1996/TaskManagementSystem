package Dev.Tejveer.TaskManagementSystem.Service;

import Dev.Tejveer.TaskManagementSystem.DTO.RoleRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.RoleResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Entity.Roles;
import Dev.Tejveer.TaskManagementSystem.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Roles role = new Roles();
        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        return RoleResponseDTO.from(roleRepository.save(role));
    }
}
