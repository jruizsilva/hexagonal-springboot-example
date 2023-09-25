package hexagonal.hexagonal.application.usecases;

import java.util.List;
import java.util.Optional;

import hexagonal.hexagonal.domain.models.Task;
import hexagonal.hexagonal.domain.ports.in.RetrieveTaskUseCase;
import hexagonal.hexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {
  private final TaskRepositoryPort taskRepositoryPort;

  @Override
  public Optional<Task> getTask(Integer id) {
    return taskRepositoryPort.findById(id);
  }

  @Override
  public List<Task> getAllTasks() {
    return taskRepositoryPort.findAll();
  }

}
