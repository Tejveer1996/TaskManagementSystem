package Dev.Tejveer.TaskManagementSystem.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "roles")
public class Roles extends BaseModel {
    private String roleName;
    private String description;
}