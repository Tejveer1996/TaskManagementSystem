package Dev.Tejveer.TaskManagementSystem.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Task extends BaseModel{
     private String title;
     private String description;
     private String status;
     private String priority;
     private LocalDate dueDate;
     @ManyToOne
     private User user;

}
