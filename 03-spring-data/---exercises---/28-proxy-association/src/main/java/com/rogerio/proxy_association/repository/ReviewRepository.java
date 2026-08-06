package com.rogerio.proxy_association.repository;

import com.rogerio.proxy_association.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
