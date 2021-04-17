package com.lmo.ninie.io.services.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.impl.*
import com.lmo.ninie.io.services.AliasService
import com.lmo.ninie.io.services.CommandService
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Service

@Service
class CommandServiceImpl(
    val aliasService: AliasService,
    val cry: Cry,
    val sing: Sing,
    val help: Help,
    val about: About,
    val meow: Meow,
    val songs: Songs,
    val fart: Fart,
    val unknown: Unknown
) : CommandService {

    override fun execute(command: Command, message: Message) =
        when (command) {
            Command.CRY -> cry
            Command.SING -> sing
            Command.HELP -> help
            Command.UNKNOWN -> unknown
            Command.ABOUT -> about
            Command.MEOW -> meow
            Command.SONGS -> songs
            Command.FART -> fart
        }.respondTo(message)

    override fun allCommands() = Command.values()

}