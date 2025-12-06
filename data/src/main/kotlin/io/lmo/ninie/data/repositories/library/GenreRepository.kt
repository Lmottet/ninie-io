package io.lmo.ninie.data.repositories.library

import io.lmo.ninie.data.entities.library.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Long>