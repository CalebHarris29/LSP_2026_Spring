package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * Provides functionality to add, find, and filter tasks.
 * 
 * @author Caleb Harris
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager with an empty task collection.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Throws an exception if a task with the same ID already exists.
     *
     * @param task the task to add
     * @throws IllegalArgumentException if duplicate task ID exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its task ID.
     *
     * @param taskId the ID of the task to find
     * @return the Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of tasks that match the given status.
     *
     * @param status the status to filter by
     * @return a list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}