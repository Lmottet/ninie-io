package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandNames.SONGS
import com.lmo.ninie.io.models.commands.CommandDescription
import com.lmo.ninie.io.models.commands.sing.Songs
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Songs : Command {
    override fun matches(commandDescription: CommandDescription): Boolean = commandDescription.action == SONGS

    override fun execute(commandDescription: CommandDescription): Mono<Message> =
            commandDescription.channel
                    .flatMap { chan -> chan.createMessage(Songs.all.map { song -> song.name() }.mkString(", ")) }
}