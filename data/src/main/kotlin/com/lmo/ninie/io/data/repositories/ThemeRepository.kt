package com.lmo.ninie.io.data.repositories

import com.lmo.ninie.io.data.entities.Theme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ThemeRepository : JpaRepository<Theme, Long>