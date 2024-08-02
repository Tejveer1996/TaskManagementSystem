package Dev.Tejveer.TaskManagementSystem.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
