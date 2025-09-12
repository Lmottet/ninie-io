package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.data.entities.AuthorSeries
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorSeriesRepository : JpaRepository<AuthorSeries, Long>