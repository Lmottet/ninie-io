package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandNames.SING
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.models.songs.Songs
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Sing : Command {

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> Songs.from(eventMessage.extractArg(1)).sing(chan) }

    override fun commandName(): String = SING

    override fun description(): String =
            """
                Sings a song
            """.trimIndent()

    override fun man(): String =
            """
                Type the song of your choice - or none if you want Ninie to pick one for you !
            """.trimIndent()

}