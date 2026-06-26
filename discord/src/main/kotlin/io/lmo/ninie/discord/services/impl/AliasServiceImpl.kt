package io.lmo.ninie.discord.services.impl

import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.CommandBase
import io.lmo.ninie.discord.services.AliasService
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl(commands: List<CommandBase>) : AliasService {

    private val commandMap = commands.associateBy { it.alias }

    override fun all(): List<Alias> = Alias.entries.toList()

    override fun find(alias: String?): Alias? = Alias.entries.find { alias == it.defaultAlias }

    override fun mapToCommand(alias: Alias): CommandBase =
        commandMap[alias] ?: commandMap[Alias.Unknown]!!
}
