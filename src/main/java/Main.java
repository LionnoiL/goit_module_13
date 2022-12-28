import entities.*;
import utils.FilesUtils;

import java.io.IOException;
import java.util.List;

import static utils.Utils.*;

public class Main {
    public static void main(String[] args) {
        testsTask1();
        testsTask2();
        testsTask3();
    }

    private static void testsTask1() {

        try {
            User testUser = createTestUser();

            User createdUser = USER_SERVICE.createUser(testUser);
            System.out.println("created user - " + createdUser);

            User updatedUser = USER_SERVICE.updateUser(testUser);
            System.out.println("updated user - " + updatedUser);

            System.out.println("user deleted - " + USER_SERVICE.deleteUser(testUser));

            List<User> users = USER_SERVICE.getUsers();
            System.out.println(users);

            User userById = USER_SERVICE.getUserById(1);
            System.out.println("user with id = 1:" + userById);

            User userByName = USER_SERVICE.getUserByName("Bret");
            System.out.println("user with name = Bret:" + userByName);

        } catch (IOException|InterruptedException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private static void testsTask2() {
        try {
            User user = USER_SERVICE.getUserById(1);

            Post lastUserPost = POST_SERVICE.getLastUserPost(user);

            List<Comment> userCommentsByPost = COMMENT_SERVICE.getUserCommentsByPost(lastUserPost);

            Comment.printComments(userCommentsByPost);

            String fileName = String.format("user-%d-post-%d-comments.json", user.getId(), lastUserPost.getId());

            FilesUtils.saveCommentsToFile(fileName, userCommentsByPost);

        } catch (IOException|InterruptedException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }


    private static void testsTask3() {
        try {

            User user = USER_SERVICE.getUserById(1);
            List<Task> openUserTasks = TASK_SERVICE.getOpenUserTasks(user);
            Task.printTasks(openUserTasks);

        } catch (IOException|InterruptedException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public static User createTestUser() {
        User user = new User();
        user.setId(1);
        user.setName("Andriy");
        user.setUsername("Gaponov");
        user.setEmail("gaponov@gmail.com");

        Address address = new Address();
        address.setCity("Podilsk");
        address.setGeo(new Geo("2222", "4545"));

        user.setAddress(address);

        return user;
    }
}
