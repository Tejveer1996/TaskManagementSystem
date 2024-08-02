package Dev.Tejveer.TaskManagementSystem.Repository;

import Dev.Tejveer.TaskManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByusername(String username);
}
