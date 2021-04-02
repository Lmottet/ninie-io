package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.CommandListener
import com.lmo.ninie.io.commands.impl.CommandNames.SING
import com.lmo.ninie.io.models.commands.Command
import com.lmo.ninie.io.models.commands.sing.Songs
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

class Sing : CommandListener {

    override fun matches(command: Command): Boolean = command.action == SING

    override fun execute(command: Command): Mono<Message> =
            command.channel
                    .flatMap { chan -> Songs.from("").sing(chan) }
}