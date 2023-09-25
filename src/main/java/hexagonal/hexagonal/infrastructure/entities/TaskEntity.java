package hexagonal.hexagonal.infrastructure.entities;

import java.time.LocalDateTime;

import hexagonal.hexagonal.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String description;
  private LocalDateTime creationDate;
  private Boolean completed;

  public static TaskEntity fromDomainModel(Task task) {
    return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(),
        task.getCompleted());
  }

  public Task toDomainModel() {
    return new Task(id, title, description, creationDate, completed);
  }
}
