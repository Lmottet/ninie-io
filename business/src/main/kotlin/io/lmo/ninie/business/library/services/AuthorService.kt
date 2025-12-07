package io.lmo.ninie.business.library.services

import io.lmo.ninie.business.library.models.read.AuthorModel
import io.lmo.ninie.business.library.models.create.CreateAuthorModel
import io.lmo.ninie.business.library.models.read.toModel
import io.lmo.ninie.data.entities.library.Author
import io.lmo.ninie.data.repositories.library.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) {

    fun list(): List<AuthorModel> = authorRepository.findAll().map { it.toModel() }.toList()
    fun get(id: Long): AuthorModel = authorRepository.findById(id).map { it.toModel() }.orElseThrow()

    fun create(request: CreateAuthorModel): AuthorModel = authorRepository.save(Author(firstName = request.firstName, lastName = request.lastName)).toModel()
}