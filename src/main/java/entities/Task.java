package entities;

import java.util.List;

public class Task {
    private long userId;
    private long id;
    private String title;
    private boolean completed;

    public Task(long userId, long id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Task() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public static void printTasks(List<Task> tasks){
        System.out.println("-----------------------------");
        System.out.println("Відкриті задачі:");
        for (Task task:tasks) {
            System.out.println("-----------------------------");
            System.out.println("id : " + task.getId());
            System.out.println("name : " + task.getTitle());

        }
    }
}
