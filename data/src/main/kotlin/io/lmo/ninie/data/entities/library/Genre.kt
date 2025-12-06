package io.lmo.ninie.data.entities.library

import io.lmo.ninie.data.entities.BaseEntity
import jakarta.persistence.Entity

@Entity
class Genre(val name: String) : BaseEntity()
