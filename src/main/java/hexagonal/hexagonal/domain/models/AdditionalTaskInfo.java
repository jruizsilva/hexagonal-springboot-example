package hexagonal.hexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AdditionalTaskInfo {
  private final Integer userId;
  private final String userName;
  private final String userEmail;

}
