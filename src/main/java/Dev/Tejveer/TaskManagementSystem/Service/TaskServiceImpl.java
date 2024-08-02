package Dev.Tejveer.TaskManagementSystem.Service;

import Dev.Tejveer.TaskManagementSystem.Exception.TaskNotFoundException;
import Dev.Tejveer.TaskManagementSystem.DTO.TaskRequestDTO;
import Dev.Tejveer.TaskManagementSystem.DTO.TaskResponseDTO;
import Dev.Tejveer.TaskManagementSystem.Entity.Task;
import Dev.Tejveer.TaskManagementSystem.Entity.User;
import Dev.Tejveer.TaskManagementSystem.Exception.UserNotFoundException;
import Dev.Tejveer.TaskManagementSystem.Repository.TaskRepository;
import Dev.Tejveer.TaskManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        User savedUser = userRepository.findById(taskRequestDTO.getUserId()).orElseThrow(
                ()-> new UserNotFoundException("Invalid userId")
        );
        Task createTask = new Task();
        createTask.setTitle(taskRequestDTO.getTitle());
        createTask.setDescription(taskRequestDTO.getDescription());
        createTask.setPriority(taskRequestDTO.getPriority());
        createTask.setStatus(taskRequestDTO.getStatus());
        createTask.setDueDate(taskRequestDTO.getDueDate());
        savedUser.getTasks().add(createTask);

        return TaskResponseDTO.from(taskRepository.save(createTask));
    }

    @Override
    public List<TaskResponseDTO> getTasks(UUID userId) {
        User savedUser = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("Invalid userId")
        );
        List<Task> tasks = userRepository.findById(userId).get().getTasks();
        List<TaskResponseDTO> responseDTOS = new ArrayList<>();
        for (Task task : tasks){
            responseDTOS.add(TaskResponseDTO.from(task));
        }

        return responseDTOS;
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        List<TaskResponseDTO> responseDTOS = new ArrayList<>();
        for (Task task : taskRepository.findAll()){
            responseDTOS.add(TaskResponseDTO.from(task));
        }
        return responseDTOS;
    }

    @Override
    public TaskResponseDTO updateTask(UUID taskId, TaskRequestDTO taskRequestDTO) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                ()-> new TaskNotFoundException("Invalid taskId")
        );
        User user = task.getUser();
        user.getTasks().remove(task);
        task.setTitle(taskRequestDTO.getTitle());
        task.setStatus(taskRequestDTO.getStatus());
        task.setPriority(taskRequestDTO.getPriority());
        task.setDescription(taskRequestDTO.getDescription());
        task.setDueDate(taskRequestDTO.getDueDate());

        user.getTasks().add(task);


        return TaskResponseDTO.from(taskRepository.save(task));
    }


    @Override
    public boolean deleteTask(UUID taskId, UUID userId) {
        User savedUser = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("Invalid userId")
        );
        Task task = taskRepository.findById(taskId).orElseThrow(
                ()-> new TaskNotFoundException("Invalid taskId")
        );

        taskRepository.delete(task);
        return true;
    }

    @Override
    public List<TaskResponseDTO> getTaskByTitle(String title) {
        List<Task> tasks = taskRepository.findByTitleContainingIgnoreCase(title).orElseThrow(
                () -> new TaskNotFoundException("No task with title "+title+" exist")
        );
        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<>();
        for (Task task : tasks){
            taskResponseDTOS.add(TaskResponseDTO.from(task));
        }
        return taskResponseDTOS;
    }

    public List<TaskResponseDTO> filterTasks(String status, String priority, LocalDate dueDate) {
        List<Task> tasks;
        if (status != null && priority != null && dueDate != null) {
            tasks = taskRepository.findByStatusAndPriorityAndDueDate(status, priority, dueDate);
        } else if (status != null && priority != null) {
            tasks = taskRepository.findByStatusAndPriorityAndDueDate(status, priority, dueDate);
        } else if (status != null) {
            tasks = taskRepository.findByStatus(status);
        } else if (priority != null) {
            tasks = taskRepository.findByPriority(priority);
        } else if (dueDate != null) {
            tasks = taskRepository.findByDueDate(dueDate);
        } else {
            tasks = taskRepository.findAll();
        }
        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<>();
        for (Task task : tasks){
            taskResponseDTOS.add(TaskResponseDTO.from(task));
        }
        return taskResponseDTOS;

    }
}
