package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Author
import com.lmo.ninie.io.data.repositories.AuthorRepository
import com.lmo.ninie.io.dto.request.CreateAuthorRequest
import com.lmo.ninie.io.dto.request.CreateBookRequest
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) {

    fun list(): List<Author> = authorRepository.findAll()

    fun create(request: CreateAuthorRequest): Author = authorRepository.save(Author(firstName = request.firstName, lastName = request.lastName))
}