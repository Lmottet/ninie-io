package io.lmo.ninie.discord.services

import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.CommandBase

interface AliasService {
    fun all(): List<CommandBase>
    fun find(alias: String?): CommandBase?
    fun mapToCommand(alias: Alias): CommandBase
}
