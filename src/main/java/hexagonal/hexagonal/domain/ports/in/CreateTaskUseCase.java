package hexagonal.hexagonal.domain.ports.in;

import hexagonal.hexagonal.domain.models.Task;

public interface CreateTaskUseCase {
  Task createTask(Task task);
}
