package services;

import com.google.gson.reflect.TypeToken;
import entities.Task;
import entities.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

import static utils.Utils.*;

public class TaskService {
    public List<Task> getUserTasks(User user) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URI + "/" + user.getId() + "/todos"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), new TypeToken<List<Task>>() {
        }.getType());

    }

    public List<Task> getOpenUserTasks(User user) throws IOException, InterruptedException {
        List<Task> tasks = getUserTasks(user);
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

}
