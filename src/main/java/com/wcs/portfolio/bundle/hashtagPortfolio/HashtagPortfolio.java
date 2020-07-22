package com.wcs.portfolio.bundle.hashtagPortfolio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wcs.portfolio.bundle.portfolio.Portfolio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HashtagPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference("portfolio-hashtag")
    @ManyToMany(mappedBy = "hashtagPortfolios")
    private List<Portfolio> Portfolios = new ArrayList<>();

    public HashtagPortfolio() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Portfolio> getPortfolios() {
        return Portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        Portfolios = portfolios;
    }
}
