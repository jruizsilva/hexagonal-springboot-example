package hexagonal.hexagonal.domain.ports.out;

import java.util.List;
import java.util.Optional;

import hexagonal.hexagonal.domain.models.Task;

public interface TaskRepositoryPort {
  Task save(Task task);

  Optional<Task> findById(Integer id);

  List<Task> findAll();

  Optional<Task> update(Task task);

  boolean deleteById(Integer id);
}
