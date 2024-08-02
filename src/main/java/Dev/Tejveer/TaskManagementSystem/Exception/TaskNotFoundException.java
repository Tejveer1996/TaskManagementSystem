package Dev.Tejveer.TaskManagementSystem.Exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException() {

    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
