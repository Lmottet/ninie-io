package io.lmo.ninie.data.entities

import jakarta.persistence.Entity

@Entity
class Genre(val name: String) : BaseEntity()
