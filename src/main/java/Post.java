import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dm.Petrov
 * DATE: 27.07.2022
 */
public class Post {
    private String id;
    private String text;
    private String type;
    private String user;
    private int upvotes;

    public Post(@JsonProperty("id") String id,@JsonProperty("text")String text, @JsonProperty("type") String type,
                @JsonProperty("user") String user, @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }

    public int getUpvotes() {
        return upvotes;
    }
}
