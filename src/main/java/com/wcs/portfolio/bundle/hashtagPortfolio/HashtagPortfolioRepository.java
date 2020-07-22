package com.wcs.portfolio.bundle.hashtagPortfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagPortfolioRepository extends JpaRepository<HashtagPortfolio, Long> {
}
