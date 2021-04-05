package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.SONGS
import com.lmo.ninie.io.constants.Songs
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Songs : Command {

    override fun commandName(): String = SONGS

    override fun description(): String = "All the songs Ninie knows !"

    override fun man(): String = "Just type it !"

    override fun execute(eventMessage: Message): Mono<Message> =
            eventMessage
                    .channel
                    .flatMap { chan -> chan.createMessage(listSongs()) }

    private fun listSongs(): String = Songs.all.map { song -> song.name() }.reduce { acc, s -> "$acc, $s" }
}