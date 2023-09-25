package hexagonal.hexagonal.application.usecases;

import hexagonal.hexagonal.domain.ports.in.DeleteTaskUseCase;
import hexagonal.hexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {
  private final TaskRepositoryPort taskRepositoryPort;

  @Override
  public boolean deleteTask(Integer id) {
    return taskRepositoryPort.deleteById(id);
  }
}
