package hexagonal.hexagonal.infrastructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import hexagonal.hexagonal.domain.models.AdditionalTaskInfo;
import hexagonal.hexagonal.domain.ports.out.ExternalServicePort;
import lombok.Getter;
import lombok.Setter;

public class ExternalServiceAdapter implements ExternalServicePort {
  /*
   * https://jsonplaceholder.typicode.com/posts
   * https://jsonplaceholder.typicode.com/users
   */

  private final RestTemplate restTemplate;

  public ExternalServiceAdapter() {
    restTemplate = new RestTemplate();
  }

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Integer taskId) {
    String apiUrl = "https://jsonplaceholder.typicode.com/posts" + taskId;
    ResponseEntity<JsonPlaceHolderTodo> todoResponse = restTemplate.getForEntity(apiUrl,
        JsonPlaceHolderTodo.class);
    JsonPlaceHolderTodo todo = todoResponse.getBody();

    if (todo == null) {
      return null;
    }
    apiUrl = "https://jsonplaceholder.typicode.com/users" + todo.getId();
    ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl,
        JsonPlaceHolderUser.class);
    JsonPlaceHolderUser user = userResponse.getBody();

    if (user == null) {
      return null;
    }
    return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
  }

  @Getter
  @Setter
  private static class JsonPlaceHolderTodo {
    private Integer id;
    private Integer userId;
  }

  @Getter
  @Setter
  private static class JsonPlaceHolderUser {
    private Integer id;
    private String name;
    private String email;
  }

}
