package hexagonal.hexagonal.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hexagonal.hexagonal.application.services.TaskService;
import hexagonal.hexagonal.domain.models.AdditionalTaskInfo;
import hexagonal.hexagonal.domain.models.Task;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
  private final TaskService taskService;

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    Task createdTask = taskService.createTask(task);
    return new ResponseEntity<Task>(createdTask, HttpStatus.CREATED);
  }

  @GetMapping("/{taskId}")
  public ResponseEntity<Task> getTaskById(@PathVariable Integer taskId) {
    return taskService.getTask(taskId).map(task -> new ResponseEntity<>(task, HttpStatus.OK))
        .orElse(new ResponseEntity<Task>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks() {
    List<Task> tasks = taskService.getAllTasks();
    return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
  }

  @PutMapping("/{taskId}")
  public ResponseEntity<Task> updateTask(@PathVariable Integer taskId, @RequestBody Task updateTask) {
    return taskService.updateTask(taskId, updateTask).map(task -> new ResponseEntity<>(task, HttpStatus.OK))
        .orElse(new ResponseEntity<Task>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTaskById(@PathVariable Integer taskId) {
    if (taskService.deleteTask(taskId)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/{taskId}/additional-info")
  public ResponseEntity<AdditionalTaskInfo> getAdditionalInfo(@PathVariable Integer taskId) {
    AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
    return new ResponseEntity<AdditionalTaskInfo>(additionalTaskInfo, HttpStatus.OK);
  }
}
