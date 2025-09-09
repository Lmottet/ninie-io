package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.data.entities.Series
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SeriesRepository : JpaRepository<Series, Long>