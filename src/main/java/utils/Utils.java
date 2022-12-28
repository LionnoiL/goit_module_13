package utils;

import com.google.gson.Gson;
import services.CommentService;
import services.PostService;
import services.TaskService;
import services.UserService;

import java.net.http.HttpClient;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }
    public static final HttpClient CLIENT = HttpClient.newHttpClient();
    public static final Gson GSON = new Gson();

    public static final String USERS_URI = "https://jsonplaceholder.typicode.com/users";
    public static final String POST_URI = "https://jsonplaceholder.typicode.com/posts";

    public static final UserService USER_SERVICE = new UserService();
    public static final PostService POST_SERVICE = new PostService();
    public static final CommentService COMMENT_SERVICE = new CommentService();
    public static final TaskService TASK_SERVICE = new TaskService();

    public static final String ERROR_MESSAGE = "Service error";

}
