package io.lmo.ninie.data.repositories.library

import io.lmo.ninie.data.entities.library.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long>