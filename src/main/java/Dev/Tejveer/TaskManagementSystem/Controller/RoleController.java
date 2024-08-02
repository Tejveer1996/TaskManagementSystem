package Dev.Tejveer.TaskManagementSystem.Controller;

import Dev.Tejveer.TaskManagementSystem.DTO.RoleRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.RoleResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Entity.Roles;
import Dev.Tejveer.TaskManagementSystem.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return ResponseEntity.ok(roleService.createRole(roleRequestDTO));
    }
}
