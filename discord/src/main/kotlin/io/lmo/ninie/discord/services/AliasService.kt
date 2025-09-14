package io.lmo.ninie.discord.services

import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.CommandBase

interface AliasService {

    fun all(): List<Alias>

    fun find(alias: String?): Alias?

    fun mapToCommand(alias: Alias): CommandBase
}