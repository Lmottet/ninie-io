package com.lmo.ninie.io.interactions.commands

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import reactor.core.publisher.Mono

interface MessageCommandBase : CommandBase {

    override fun respondTo(message: Message): Mono<MessageData> =
       message.restChannel.createMessage(response(message))

    fun response(message: Message): String

}