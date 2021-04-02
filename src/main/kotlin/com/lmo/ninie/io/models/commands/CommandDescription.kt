package com.lmo.ninie.io.models.commands

import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

data class CommandDescription(
        val action: String,
        val payload: String?,
        val channel: Mono<MessageChannel>
)