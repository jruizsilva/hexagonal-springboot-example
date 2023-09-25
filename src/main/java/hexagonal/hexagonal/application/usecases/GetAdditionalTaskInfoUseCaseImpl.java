package hexagonal.hexagonal.application.usecases;

import hexagonal.hexagonal.domain.models.AdditionalTaskInfo;
import hexagonal.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import hexagonal.hexagonal.domain.ports.out.ExternalServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
  private final ExternalServicePort externalServicePort;

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Integer id) {
    return externalServicePort.getAdditionalTaskInfo(id);
  }

}
