package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.SING
import com.lmo.ninie.io.constants.Songs
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import discord4j.core.`object`.entity.Message
import io.vavr.kotlin.option
import reactor.core.publisher.Mono

class Sing : AbstractCommand(
        SING,
        "Sing a song of your choice (or random)",
        "optional : [song name]"
) {

    override fun response(message: Message) = message.extractArg(1)
            .option()
            .map { songName -> Songs.from(songName).option().getOrElse(Songs.any()) }
            .getOrElse(Songs.any())
            .content()

}