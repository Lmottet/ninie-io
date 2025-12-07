package io.lmo.ninie.data.repositories.library

import io.lmo.ninie.data.entities.library.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long>
