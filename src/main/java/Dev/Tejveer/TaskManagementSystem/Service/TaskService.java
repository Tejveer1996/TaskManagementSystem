package Dev.Tejveer.TaskManagementSystem.Service;

import Dev.Tejveer.TaskManagementSystem.DTO.TaskRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.TaskResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Entity.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);
    List<TaskResponseDTO> getTasks(UUID userId);
    List<TaskResponseDTO> getAllTasks();
    TaskResponseDTO updateTask(UUID taskId,TaskRequestDTO taskRequestDTO);

    boolean deleteTask(UUID taskId , UUID userId);

    List<TaskResponseDTO> getTaskByTitle(String title);
    List<TaskResponseDTO> filterTasks(String status, String priority, LocalDate dueDate);
}
