package hexagonal.hexagonal.domain.ports.in;

import java.util.List;
import java.util.Optional;

import hexagonal.hexagonal.domain.models.Task;

public interface RetrieveTaskUseCase {
  Optional<Task> getTask(Integer id);

  List<Task> getAllTasks();
}
