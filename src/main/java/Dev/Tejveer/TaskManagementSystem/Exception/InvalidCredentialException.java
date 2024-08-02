package Dev.Tejveer.TaskManagementSystem.Exception;

public class InvalidCredentialException extends RuntimeException{
    public InvalidCredentialException() {

    }

    public InvalidCredentialException(String message) {
        super(message);
    }
}
