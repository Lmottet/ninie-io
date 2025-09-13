package com.lmo.ninie.io.services

import com.lmo.ninie.io.data.entities.Author
import com.lmo.ninie.io.data.repositories.AuthorRepository
import com.lmo.ninie.io.models.AuthorModel
import com.lmo.ninie.io.models.CreateAuthorModel
import com.lmo.ninie.io.models.toModel
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) {

    fun list(): List<AuthorModel> = authorRepository.findAll().map { it.toModel() }.toList()
    fun get(id: Long): AuthorModel = authorRepository.findById(id).map { it.toModel() }.orElseThrow()

    fun create(request: CreateAuthorModel): AuthorModel = authorRepository.save(Author(firstName = request.firstName, lastName = request.lastName)).toModel()
}