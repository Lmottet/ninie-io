package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

abstract class CommandBase {
    abstract fun respondTo(message: Message): Mono<Unit>
}