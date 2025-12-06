package io.lmo.ninie.data.repositories.library

import io.lmo.ninie.data.entities.library.Series
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SeriesRepository : JpaRepository<Series, Long>