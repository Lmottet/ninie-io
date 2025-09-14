package io.lmo.ninie.data.entities

import jakarta.persistence.Entity

@Entity
class Theme(val name: String) : BaseEntity()
