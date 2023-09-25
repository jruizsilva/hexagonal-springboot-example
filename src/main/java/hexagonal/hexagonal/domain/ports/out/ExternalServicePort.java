package hexagonal.hexagonal.domain.ports.out;

import hexagonal.hexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
  AdditionalTaskInfo getAdditionalTaskInfo(Integer id);
}
