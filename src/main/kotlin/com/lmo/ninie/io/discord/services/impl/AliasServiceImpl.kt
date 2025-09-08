package com.lmo.ninie.io.discord.services.impl

import com.lmo.ninie.io.discord.interactions.commands.Alias
import com.lmo.ninie.io.discord.interactions.commands.CommandBase
import com.lmo.ninie.io.discord.interactions.commands.impl.*
import com.lmo.ninie.io.discord.services.AliasService
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl(
    val about: About,
    val cry: Cry,
    val fart: Fart,
    val help: Help,
    val meow: Meow,
    val sing: Sing,
    val songs: Songs,
    val unknown: Unknown
) : AliasService {

    override fun all(): List<Alias> = Alias.entries

    override fun find(alias: String?) = all()
        .find { alias == it.defaultAlias }

    override fun mapToCommand(alias: Alias): CommandBase =
        when (alias) {
            Alias.About -> about
            Alias.Cry -> cry
            Alias.Fart -> fart
            Alias.Help -> help
            Alias.Meow -> meow
            Alias.Sing -> sing
            Alias.Songs -> songs
            Alias.Unknown -> unknown
        }

}