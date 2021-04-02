package com.lmo.ninie.io.events.message.commands

import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

data class Command(
        val action: String,
        val payload: String?,
        val channel: Mono<MessageChannel>
)