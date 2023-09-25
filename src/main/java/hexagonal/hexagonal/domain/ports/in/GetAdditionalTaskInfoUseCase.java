package hexagonal.hexagonal.domain.ports.in;

import hexagonal.hexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
  AdditionalTaskInfo getAdditionalTaskInfo(Integer id);

}
