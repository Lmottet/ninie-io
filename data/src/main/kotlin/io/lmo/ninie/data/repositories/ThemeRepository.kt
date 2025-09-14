package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.Theme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ThemeRepository : JpaRepository<Theme, Long>