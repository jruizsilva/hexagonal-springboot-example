package hexagonal.hexagonal.application.usecases;

import hexagonal.hexagonal.domain.models.Task;
import hexagonal.hexagonal.domain.ports.in.CreateTaskUseCase;
import hexagonal.hexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
  private final TaskRepositoryPort taskRepositoryPort;

  @Override
  public Task createTask(Task task) {
    return taskRepositoryPort.save(task);
  }

}
