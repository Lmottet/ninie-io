package io.lmo.ninie.data.repositories.review

import io.lmo.ninie.data.entities.review.SeriesReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SeriesReviewRepository : JpaRepository<SeriesReview, Long>