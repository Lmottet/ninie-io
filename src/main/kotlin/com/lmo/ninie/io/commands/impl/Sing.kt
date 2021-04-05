package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.SING
import com.lmo.ninie.io.constants.Songs
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import reactor.core.publisher.Mono

class Sing : Command {

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> chan.createMessage(findSong(eventMessage.extractArg(1))) }

    private fun findSong(songName: Option<String>): String = songName.flatMap { name -> Songs.from(name) }.getOrElse(Songs.any()).content()

    override fun commandName(): String = SING

    override fun description(): String = "Sing a song of your choice (or random)"

    override fun man(): String = "optional : [song name]"

}