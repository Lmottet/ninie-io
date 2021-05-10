package com.lmo.ninie.io.services.impl

import com.lmo.ninie.io.interactions.commands.Alias
import com.lmo.ninie.io.interactions.commands.CommandBase
import com.lmo.ninie.io.interactions.commands.impl.*
import com.lmo.ninie.io.services.AliasService
import discord4j.discordjson.json.MessageData
import io.vavr.kotlin.option
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

    override fun all(): List<Alias> = Alias.values().toList()

    override fun find(alias: String?) = all()
        .find { alias == it.defaultAlias }
        .option()

    override fun mapToCommand(alias: Alias): CommandBase<MessageData> =
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