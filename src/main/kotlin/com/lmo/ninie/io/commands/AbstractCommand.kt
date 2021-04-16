package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.MessageData
import reactor.core.publisher.Mono

abstract class AbstractCommand {
    abstract fun respondTo(message: Message): Mono<Unit>
}