package com.lmo.ninie.io.services

import com.lmo.ninie.io.interactions.commands.Alias
import com.lmo.ninie.io.interactions.commands.CommandBase

interface AliasService {

    fun all(): List<Alias>

    fun find(alias: String?): Alias?

    fun mapToCommand(alias: Alias): CommandBase
}