package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.SING
import com.lmo.ninie.io.constants.Songs
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.models.songs.Song
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import reactor.core.publisher.Mono

class Sing : Command {

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage.
                    channel.
                    flatMap { chan -> chan.createMessage(findSong(eventMessage.extractArg(1)).content()) }

    private fun findSong(songName: String?): Song {
        return if(songName == null) Songs.any() else Songs.from(songName).getOrElse(Songs.any())
    }

    override fun commandName(): String = SING

    override fun description(): String = "Sing a song of your choice (or random)"

    override fun man(): String = "optional : [song name]"

}