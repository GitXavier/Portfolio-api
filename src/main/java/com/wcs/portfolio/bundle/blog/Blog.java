package com.wcs.portfolio.bundle.blog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wcs.portfolio.bundle.ApplicationUser.ApplicationUser;
import com.wcs.portfolio.bundle.hashtagBlog.Hashtag;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String picture;

    private boolean isShow = false;

    @CreatedDate
    private Date created_at;

    @CreatedDate
    private Date updated_at;

    @JsonIgnoreProperties("blogs")
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "blog_hashtag",
            joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id", referencedColumnName = "id"),
            uniqueConstraints={@UniqueConstraint(columnNames={"blog_id", "hashtag_id"})})
    private List<Hashtag> hashtags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    public Blog() { }

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}
