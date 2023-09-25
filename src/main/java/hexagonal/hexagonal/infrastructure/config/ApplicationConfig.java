package hexagonal.hexagonal.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hexagonal.hexagonal.application.services.TaskService;
import hexagonal.hexagonal.application.usecases.CreateTaskUseCaseImpl;
import hexagonal.hexagonal.application.usecases.DeleteTaskUseCaseImpl;
import hexagonal.hexagonal.application.usecases.GetAdditionalTaskInfoUseCaseImpl;
import hexagonal.hexagonal.application.usecases.RetrieveTaskUseCaseImpl;
import hexagonal.hexagonal.application.usecases.UpdateTaskUseCaseImpl;
import hexagonal.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import hexagonal.hexagonal.domain.ports.out.ExternalServicePort;
import hexagonal.hexagonal.domain.ports.out.TaskRepositoryPort;
import hexagonal.hexagonal.infrastructure.adapters.ExternalServiceAdapter;
import hexagonal.hexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {

  @Bean
  public TaskService taskService(TaskRepositoryPort taskRepositoryPort,
      GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
    return new TaskService(new CreateTaskUseCaseImpl(taskRepositoryPort),
        new RetrieveTaskUseCaseImpl(taskRepositoryPort), new UpdateTaskUseCaseImpl(taskRepositoryPort),
        new DeleteTaskUseCaseImpl(taskRepositoryPort), getAdditionalTaskInfoUseCase);
  }

  @Bean
  public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
    return jpaTaskRepositoryAdapter;
  }

  @Bean
  GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
    return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
  }

  @Bean
  public ExternalServicePort externalServicePort() {
    return new ExternalServiceAdapter();
  }
}
