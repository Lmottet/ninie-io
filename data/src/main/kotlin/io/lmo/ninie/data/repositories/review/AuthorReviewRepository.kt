package io.lmo.ninie.data.repositories.review

import io.lmo.ninie.data.entities.review.AuthorReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorReviewRepository : JpaRepository<AuthorReview, Long>