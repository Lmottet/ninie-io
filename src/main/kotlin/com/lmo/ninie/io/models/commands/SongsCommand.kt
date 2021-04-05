package com.lmo.ninie.io.models.commands

import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

data class SongsCommand(
        override val action: String,
        override val channel: Mono<MessageChannel>
) : CommandDescription()