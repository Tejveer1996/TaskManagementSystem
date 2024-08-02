package Dev.Tejveer.TaskManagementSystem.Service;

import Dev.Tejveer.TaskManagementSystem.DTO.LoginRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.SignUpRequestDto;
import Dev.Tejveer.TaskManagementSystem.DTO.UserResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Entity.Roles;
import Dev.Tejveer.TaskManagementSystem.Entity.User;
import Dev.Tejveer.TaskManagementSystem.Exception.InvalidCredentialException;
import Dev.Tejveer.TaskManagementSystem.Exception.RoleNotFoundException;
import Dev.Tejveer.TaskManagementSystem.Exception.UserNotFoundException;
import Dev.Tejveer.TaskManagementSystem.Repository.RoleRepository;
import Dev.Tejveer.TaskManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO signUp(SignUpRequestDto signUpRequestDto) {
        Roles role = roleRepository.findById(signUpRequestDto.getRoleId()).orElseThrow(
                ()-> new RoleNotFoundException("Role not found")
        );
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setEmailId(signUpRequestDto.getEmailId());
        user.setUsername(signUpRequestDto.getUsername());
        user.setPassword(encoder.encode(signUpRequestDto.getPassword()));

        return UserResponseDTO.from(userRepository.save(user));

    }

    @Override
    public UserResponseDTO logIn(LoginRequestDTO loginRequestDTO) {
        User savedUser = userRepository.findByusername(loginRequestDTO.getUsername()).orElseThrow(
                ()-> new UserNotFoundException("UserName is incorrect")
        );
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword())){
            String userData = savedUser.getEmailId() + savedUser.getUsername() + LocalDate.now();
            String token = passwordEncoder.encode(userData);
            savedUser.setToken(token);

        }else{
            throw new InvalidCredentialException();
        }

        savedUser = userRepository.save(savedUser);

        return UserResponseDTO.from(savedUser);
    }


}
