package entities;

import java.util.List;

public class Comment {

    private long postId;
    private long id;
    private String name;
    private String email;
    private String body;

    public Comment(long postId, long id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Comment() {
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public static void printComments(List<Comment> comments){
        for (Comment comment:comments) {
            System.out.println("-----------------------------");
            System.out.println(String.format("Коментар #%d до посту #%d:", comment.getId(), comment.getPostId()));
            System.out.println("email : " + comment.getEmail());
            System.out.println("name : " + comment.getName());
            System.out.println("text : " + comment.getBody());
        }
    }
}
