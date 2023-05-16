package com.example.homework12task.Controller;

import com.example.homework12task.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    ArrayList<Task> tasks = new ArrayList<>();

    //Create a new tasks (title , description , status)
    @PostMapping("/create")
    public String createTask(@RequestBody Task task){
        tasks.add(task);
        return "Task created";
    }

    //Display all tasks
    @GetMapping("/display")
    public ArrayList<Task> display(){
        return tasks;
    }

    //Update a task
    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index,@RequestBody Task task){
        if (index > (tasks.size()-1))
            return "Not found";
        tasks.set(index,task);
        return "Task updated";
    }


    //Delete a task
    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        if (index > (tasks.size()-1))
            return "Not found";
        tasks.remove(index);
        return "Task deleted";
    }


    //Change the task status as done or not done
    @PutMapping("/status/{index}")
    public String updateStatus(@PathVariable int index,@RequestBody String status){
        if (index > (tasks.size()-1))
            return "Not found";
        tasks.get(index).setStatus(status);
        return "Status updated";
    }


    //Search for a task by given title

    @PutMapping("/search")
    public Task search(@RequestBody String title){
        Task task = null;
        for (Task t: tasks) {
            if (t.getTitle().equals(title)){
                task = t;
                break;
            }
        }
        return task;
    }

}
