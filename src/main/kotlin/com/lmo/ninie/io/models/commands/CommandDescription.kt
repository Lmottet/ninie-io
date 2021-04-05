package com.lmo.ninie.io.models.commands

import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

abstract class CommandDescription{
        abstract val action: String
        abstract val channel: Mono<MessageChannel>
}