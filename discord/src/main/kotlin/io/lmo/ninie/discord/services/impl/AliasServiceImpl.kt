package io.lmo.ninie.discord.services.impl

import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.CommandBase
import io.lmo.ninie.discord.services.AliasService
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl(commands: List<CommandBase>) : AliasService {

    private val commandMap = commands.associateBy { it.alias }

    override fun all(): List<CommandBase> = Alias.entries.mapNotNull { commandMap[it] }

    override fun find(alias: String?): CommandBase? =
        Alias.entries.find { it.defaultAlias == alias }?.let { commandMap[it] }

    override fun mapToCommand(alias: Alias): CommandBase =
        commandMap[alias] ?: commandMap[Alias.Unknown]!!
}
