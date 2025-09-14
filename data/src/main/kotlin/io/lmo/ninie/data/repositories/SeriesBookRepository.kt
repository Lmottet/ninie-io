package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.SeriesBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SeriesBookRepository : JpaRepository<SeriesBook, Long>