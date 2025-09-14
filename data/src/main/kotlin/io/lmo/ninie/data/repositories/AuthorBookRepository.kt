package io.lmo.ninie.data.repositories

import io.lmo.ninie.data.entities.AuthorBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorBookRepository : JpaRepository<AuthorBook, Long>