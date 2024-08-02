package Dev.Tejveer.TaskManagementSystem.DTO;

import com.sun.jdi.event.StepEvent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.UUID;

@Getter
@Setter
public class SignUpRequestDto {
    private String username;
    private String password;
    private String emailId;
    private UUID roleId;
}
