package com.lmo.ninie.io.services.commands.impl

import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.commands.CommandBase
import com.lmo.ninie.io.commands.impl.*
import com.lmo.ninie.io.services.commands.AliasService
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

    override fun all(): List<Alias> = Alias::class.nestedClasses.map { it.objectInstance as Alias }

    override fun find(alias: String?) = all()
        .find { e -> e.defaultAlias == alias }
        .option()

    override fun mapToCommand(alias: Alias): CommandBase<MessageData> = when (alias) {
        is Alias.About -> about
        is Alias.Cry -> cry
        is Alias.Fart -> fart
        is Alias.Help -> help
        is Alias.Meow -> meow
        is Alias.Sing -> sing
        is Alias.Songs -> songs
        is Alias.Unknown -> unknown
    }


}