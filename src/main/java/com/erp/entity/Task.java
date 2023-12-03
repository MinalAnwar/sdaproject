package com.erp.entity;

public class Task {
    private int TaskId;
    private String name;
    private String Description;
    private String status;
    private String deadline;

    public Task(){}

    public Task(int taskId, String name, String description, String status, String deadline) {
        TaskId = taskId;
        this.name = name;
        Description = description;
        this.status = status;
        this.deadline = deadline;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getTaskId() {
        return TaskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public String getStatus() {
        return status;
    }

    public String getDeadline() {
        return deadline;
    }
}
