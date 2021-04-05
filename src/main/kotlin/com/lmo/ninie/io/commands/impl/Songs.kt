package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandNames.SONGS
import com.lmo.ninie.io.models.songs.Songs
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Songs : Command {

    override fun commandName(): String = SONGS

    override fun description(): String = "Lists all the songs Ninie knows !"

    override fun man(): String = "Just type it !"

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                .channel
                .flatMap { chan -> chan.createMessage(Songs.all.map { song -> song.name() }.mkString(", ")) }
}