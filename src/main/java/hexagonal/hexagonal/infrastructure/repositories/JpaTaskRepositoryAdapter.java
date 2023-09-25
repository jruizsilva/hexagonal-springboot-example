package hexagonal.hexagonal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import hexagonal.hexagonal.domain.models.Task;
import hexagonal.hexagonal.domain.ports.out.TaskRepositoryPort;
import hexagonal.hexagonal.infrastructure.entities.TaskEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

  private final JpaTaskRepository jpaTaskRepository;

  @Override
  public Task save(Task task) {
    TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
    TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
    return savedTaskEntity.toDomainModel();
  }

  @Override
  public Optional<Task> findById(Integer id) {
    return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
  }

  @Override
  public List<Task> findAll() {
    return jpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).toList();
  }

  @Override
  public Optional<Task> update(Task task) {
    if (jpaTaskRepository.existsById(task.getId())) {
      TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
      TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
      return Optional.of(updatedTaskEntity.toDomainModel());
    }
    return Optional.empty();
  }

  @Override
  public boolean deleteById(Integer id) {
    if (jpaTaskRepository.existsById(id)) {
      jpaTaskRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
