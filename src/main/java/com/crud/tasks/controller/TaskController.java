package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

//    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

//    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(
                service.getTask(taskId).orElseThrow(TaskNotFoundException::new)
        );
    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        service.deleteTask(taskId);
    }
//    public void deleteTask(@RequestParam Long taskId) throws TaskNotFoundException {
//       try {
//           service.deleteTask(taskId);
//       } catch(Exception e) {
//           throw new TaskNotFoundException();
//        }
//    }

//    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    @RequestMapping(method = RequestMethod.PUT, value = "/tasks")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        //Task task = taskMapper.mapToTask(taskDto);
        //Task savedTask = service.saveTask(taskMapper.mapToTask(taskDto));
        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
    }

    //@RequestMapping(method = RequestMethod.POST, value = "createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }
}