package Dev.Tejveer.TaskManagementSystem.Controller;

import Dev.Tejveer.TaskManagementSystem.DTO.TaskRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.TaskResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO taskRequestDTO){
        return ResponseEntity.ok(taskService.createTask(taskRequestDTO));
    }

    @PostMapping("/update/{taskId}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable UUID taskId, @RequestBody TaskRequestDTO taskRequestDTO ){
        return ResponseEntity.ok(taskService.updateTask(taskId,taskRequestDTO));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/tasks/search")
    public ResponseEntity<List<TaskResponseDTO>> getTaskByTitle(@RequestBody String title){
        return ResponseEntity.ok(taskService.getTaskByTitle(title));
    }
    @GetMapping("/filter")
    public ResponseEntity<List<TaskResponseDTO>> filterTasks(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String priority,
            @RequestParam(required = false) LocalDate dueDate) {
        return ResponseEntity.ok(taskService.filterTasks(status, priority, dueDate));
    }

    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> getTasksOfUser(@PathVariable UUID userID){
        return ResponseEntity.ok(taskService.getTasks(userID));
    }

    @DeleteMapping("/task/{taskId}/{userId}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID taskId, @PathVariable UUID userId){
        return ResponseEntity.ok(taskService.deleteTask(taskId,userId));
    }
}
