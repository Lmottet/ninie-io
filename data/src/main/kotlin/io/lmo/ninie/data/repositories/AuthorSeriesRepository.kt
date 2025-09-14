package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.AuthorSeries
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorSeriesRepository : JpaRepository<AuthorSeries, Long>