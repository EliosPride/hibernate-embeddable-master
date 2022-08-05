package ma.hibernate.embeddable.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class NewsPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate postDate;
    private String topic;
    private String content;
    @Embedded
    private PostMetadata metadata;

    public NewsPost() {
    }

    public NewsPost(LocalDate postDate, String topic, String content) {
        this.postDate = postDate;
        this.topic = topic;
        this.content = content;
    }

    public NewsPost(LocalDate postDate, String topic, String content, PostMetadata metadata) {
        this.postDate = postDate;
        this.topic = topic;
        this.content = content;
        this.metadata = metadata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(PostMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsPost newsPost = (NewsPost) o;
        return Objects.equals(id, newsPost.id) && Objects.equals(postDate, newsPost.postDate) && Objects.equals(topic, newsPost.topic) && Objects.equals(content, newsPost.content) && Objects.equals(metadata, newsPost.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postDate, topic, content, metadata);
    }

    @Override
    public String toString() {
        return "NewsPost{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
