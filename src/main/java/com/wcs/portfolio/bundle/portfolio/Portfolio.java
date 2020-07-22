package com.wcs.portfolio.bundle.portfolio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wcs.portfolio.bundle.ApplicationUser.ApplicationUser;
import com.wcs.portfolio.bundle.hashtagPortfolio.HashtagPortfolio;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 255)
    private String link;

    @Column(length = 255)
    private String picture;

    private boolean isShow = false;

    @CreatedDate
    private Date created_at;

    @CreatedDate
    private Date updated_at;

    @JsonManagedReference("portfolio-hashtag")
    @ManyToMany()
    @JoinTable(name = "portfolio_hashtag",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtagPortfolio_id"))
    private List<HashtagPortfolio> hashtagPortfolios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    public Portfolio() { }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public List<HashtagPortfolio> getHashtagPortfolios() {
        return hashtagPortfolios;
    }

    public void setHashtagPortfolios(List<HashtagPortfolio> hashtagPortfolios) {
        this.hashtagPortfolios = hashtagPortfolios;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}
