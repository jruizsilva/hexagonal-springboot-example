package hexagonal.hexagonal.application.usecases;

import java.util.Optional;

import hexagonal.hexagonal.domain.models.Task;
import hexagonal.hexagonal.domain.ports.in.UpdateTaskUseCase;
import hexagonal.hexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
  private final TaskRepositoryPort taskRepositoryPort;

  @Override
  public Optional<Task> updateTask(Integer id, Task updateTask) {
    return taskRepositoryPort.update(updateTask);
  }

}
