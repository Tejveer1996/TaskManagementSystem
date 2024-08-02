package Dev.Tejveer.TaskManagementSystem.Service;

import Dev.Tejveer.TaskManagementSystem.DTO.LoginRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.SignUpRequestDto;
import Dev.Tejveer.TaskManagementSystem.DTO.UserResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Entity.User;
import Dev.Tejveer.TaskManagementSystem.Repository.UserRepository;

import java.util.Optional;

public interface UserService {
    UserResponseDTO signUp(SignUpRequestDto signUpRequestDto);
    UserResponseDTO logIn(LoginRequestDTO loginRequestDTO);
}
