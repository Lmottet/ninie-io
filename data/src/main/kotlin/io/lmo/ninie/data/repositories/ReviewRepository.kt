package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long>