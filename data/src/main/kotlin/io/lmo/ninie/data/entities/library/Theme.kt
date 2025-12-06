package io.lmo.ninie.data.entities.library

import io.lmo.ninie.data.entities.BaseEntity
import jakarta.persistence.Entity

@Entity
class Theme(val name: String) : BaseEntity()
