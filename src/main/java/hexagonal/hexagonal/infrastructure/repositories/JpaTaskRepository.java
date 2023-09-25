package hexagonal.hexagonal.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hexagonal.hexagonal.infrastructure.entities.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Integer> {

}
