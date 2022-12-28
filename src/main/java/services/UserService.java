package services;

import com.google.gson.reflect.TypeToken;
import entities.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static utils.Utils.*;

public class UserService {

    public User createUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URI))
                .header("Content-type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }


    public User updateUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URI + "/" + user.getId()))
                .header("Content-type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    public boolean deleteUser(User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URI + "/" + user.getId()))
                .DELETE()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return  response.statusCode() >= 200 && response.statusCode() < 300;

    }

    public List<User> getUsers() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URI))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), new TypeToken<List<User>>() {
        }.getType());
    }


    public User getUserById(long userId) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URI + "/" + userId))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);
    }

    public User getUserByName(String userName) throws IOException, InterruptedException {
        String uri = String.format("%s?username=%s",USERS_URI, userName);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        List<User> findedUsers = GSON.fromJson(response.body(), new TypeToken<List<User>>() {
        }.getType());

        User result = null;
        if (findedUsers.size() == 1){
            result = findedUsers.get(0);
        }

        return result;
    }


}
