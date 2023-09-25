package hexagonal.hexagonal.domain.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
  private Integer id;
  private String title;
  private String description;
  private LocalDateTime creationDate;
  private Boolean completed;
}
