package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.data.entities.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Long>