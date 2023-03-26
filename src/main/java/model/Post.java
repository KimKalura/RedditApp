package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;
    @Column
    private String postName;
    @Column
    private String description;
    @Column
    private Integer voteCount;
    @Column
    private LocalDateTime createdDate;
    @ManyToOne
    @JsonBackReference(value = "subreddit-post")
    @JoinColumn(name = "subreddit_Id")
    private Subreddit subreddit;

    public Post() {
    }

    public Post(Long id, String postName, String description, Integer voteCount, LocalDateTime createdDate, Subreddit subreddit) {
        this.id = id;
        this.postName = postName;
        this.description = description;
        this.voteCount = voteCount;
        this.createdDate = createdDate;
        this.subreddit = subreddit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Subreddit getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(Subreddit subreddit) {
        this.subreddit = subreddit;
    }

}
