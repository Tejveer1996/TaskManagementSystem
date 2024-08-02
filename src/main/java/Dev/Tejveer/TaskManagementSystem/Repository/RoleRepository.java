package Dev.Tejveer.TaskManagementSystem.Repository;

import Dev.Tejveer.TaskManagementSystem.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Roles, UUID> {
}
