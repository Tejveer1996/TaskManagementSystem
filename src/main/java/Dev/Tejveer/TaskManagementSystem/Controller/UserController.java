package Dev.Tejveer.TaskManagementSystem.Controller;

import Dev.Tejveer.TaskManagementSystem.DTO.LoginRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.SignUpRequestDto;
import Dev.Tejveer.TaskManagementSystem.DTO.UserResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        return ResponseEntity.ok(userService.signUp(signUpRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.logIn(loginRequestDTO));
    }
}
