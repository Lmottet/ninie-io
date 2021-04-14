package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.Songs
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import discord4j.core.`object`.entity.Message
import io.vavr.kotlin.option
import org.springframework.stereotype.Component

@Component
class Sing : AbstractCommand(Command.SING) {

    override fun respondTo(message: Message) = message.extractArg(1)
        .option()
        .map { songName -> Songs.from(songName).getOrElse(Songs.any()) }
        .getOrElse(Songs.any())
        .content()

}