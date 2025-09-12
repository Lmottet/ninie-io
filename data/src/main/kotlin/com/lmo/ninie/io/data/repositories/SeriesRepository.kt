package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.data.entities.Series
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SeriesRepository : JpaRepository<Series, Long> {

    @EntityGraph(attributePaths = ["authorSeries", "authorSeries.author"])
    @Query("SELECT s FROM Series s WHERE s.id = :id")
    fun findByIdWithInfo(id: Long): Optional<Series>

}