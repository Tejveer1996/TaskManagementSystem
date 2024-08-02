package Dev.Tejveer.TaskManagementSystem.Repository;

import Dev.Tejveer.TaskManagementSystem.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    Optional<List<Task>> findByTitleContainingIgnoreCase(String title);
    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByDueDate(LocalDate dueDate);

    List<Task> findByStatusAndPriorityAndDueDate(String status, String priority, LocalDate dueDate);
}
