package io.lmo.ninie.data.entities.library

import io.lmo.ninie.data.entities.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Genre(@Column(nullable = false, length = 60) val name: String) : BaseEntity()
