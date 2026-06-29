package io.lmo.ninie.data.repositories.review

import io.lmo.ninie.data.entities.review.BookReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookReviewRepository : JpaRepository<BookReview, Long>