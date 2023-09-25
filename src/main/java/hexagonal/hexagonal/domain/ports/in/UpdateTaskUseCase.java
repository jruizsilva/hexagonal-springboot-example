package hexagonal.hexagonal.domain.ports.in;

import java.util.Optional;

import hexagonal.hexagonal.domain.models.Task;

public interface UpdateTaskUseCase {
  Optional<Task> updateTask(Integer id, Task updateTask);
}
