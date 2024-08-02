package Dev.Tejveer.TaskManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class TaskRequestDTO {
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDate dueDate;
    private UUID userId;
}
