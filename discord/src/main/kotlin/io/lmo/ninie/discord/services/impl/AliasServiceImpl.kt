package io.lmo.ninie.discord.services.impl

import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.CommandBase
import io.lmo.ninie.discord.services.AliasService
import io.lmo.ninie.discord.interactions.commands.impl.About
import io.lmo.ninie.discord.interactions.commands.impl.Cry
import io.lmo.ninie.discord.interactions.commands.impl.Fart
import io.lmo.ninie.discord.interactions.commands.impl.Help
import io.lmo.ninie.discord.interactions.commands.impl.Meow
import io.lmo.ninie.discord.interactions.commands.impl.Sing
import io.lmo.ninie.discord.interactions.commands.impl.Songs
import io.lmo.ninie.discord.interactions.commands.impl.Unknown
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