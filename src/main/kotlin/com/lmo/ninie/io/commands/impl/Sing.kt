package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.commands.CommandNames.SING
import com.lmo.ninie.io.models.commands.CommandDescription
import com.lmo.ninie.io.models.commands.sing.Songs
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Sing : Command {

    override fun matches(commandDescription: CommandDescription): Boolean = commandDescription.action == SING

    override fun execute(commandDescription: CommandDescription): Mono<Message> =
            commandDescription.channel
                    .flatMap { chan -> Songs.from("").sing(chan) }
}