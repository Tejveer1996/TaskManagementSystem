package Dev.Tejveer.TaskManagementSystem.DTO;

import Dev.Tejveer.TaskManagementSystem.Entity.Task;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TaskResponseDTO {
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDate dueDate;


    public static TaskResponseDTO from(Task task){
        if (task == null){
            return null;
        }
        TaskResponseDTO responseDTO = new TaskResponseDTO();
        responseDTO.title = task.getTitle();
        responseDTO.description = task.getDescription();
        responseDTO.status = task.getStatus();
        responseDTO.priority = task.getPriority();
        responseDTO.dueDate = task.getDueDate();

        return responseDTO;
    }
}
