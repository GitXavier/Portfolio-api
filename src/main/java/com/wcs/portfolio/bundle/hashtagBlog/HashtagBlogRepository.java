package com.wcs.portfolio.bundle.hashtagBlog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagBlogRepository extends JpaRepository<HashtagBlog, Long> {
}
