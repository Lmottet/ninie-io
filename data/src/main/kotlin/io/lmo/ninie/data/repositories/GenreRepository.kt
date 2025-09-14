package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Long>