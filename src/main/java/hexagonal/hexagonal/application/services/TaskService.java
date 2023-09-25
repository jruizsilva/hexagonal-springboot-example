package hexagonal.hexagonal.application.services;

import java.util.List;
import java.util.Optional;

import hexagonal.hexagonal.domain.models.AdditionalTaskInfo;
import hexagonal.hexagonal.domain.models.Task;
import hexagonal.hexagonal.domain.ports.in.CreateTaskUseCase;
import hexagonal.hexagonal.domain.ports.in.DeleteTaskUseCase;
import hexagonal.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import hexagonal.hexagonal.domain.ports.in.RetrieveTaskUseCase;
import hexagonal.hexagonal.domain.ports.in.UpdateTaskUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskService implements RetrieveTaskUseCase, CreateTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase,
    GetAdditionalTaskInfoUseCase {

  private final CreateTaskUseCase createTaskUseCase;
  private final RetrieveTaskUseCase retrieveTaskUseCase;
  private final UpdateTaskUseCase updateTaskUseCase;
  private final DeleteTaskUseCase deleteTaskUseCase;
  private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Integer id) {
    return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
  }

  @Override
  public boolean deleteTask(Integer id) {
    return deleteTaskUseCase.deleteTask(id);
  }

  @Override
  public Optional<Task> updateTask(Integer id, Task updateTask) {
    return updateTaskUseCase.updateTask(id, updateTask);
  }

  @Override
  public Task createTask(Task task) {
    return createTaskUseCase.createTask(task);
  }

  @Override
  public Optional<Task> getTask(Integer id) {
    return retrieveTaskUseCase.getTask(id);
  }

  @Override
  public List<Task> getAllTasks() {
    return retrieveTaskUseCase.getAllTasks();
  }

}
