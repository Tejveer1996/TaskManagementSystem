package Dev.Tejveer.TaskManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "user")
public class User extends BaseModel{

    private String username;
    private String password;
    private String emailId;
    private String token;
    @ManyToMany
    private List<Roles> roles;
    @OneToMany
    private List<Task> tasks;

}
