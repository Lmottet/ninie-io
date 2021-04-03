package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.models.commands.CommandDescription
import com.lmo.ninie.io.commands.CommandListeners
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface MessageListener {

    fun processEvent(eventMessage: Message): Mono<Unit> {
        return Mono
                .just(eventMessage)
                .filter { message -> !message.author.get().isBot && message.content.startsWith("p") }
                .map {message -> buildCommand(message)}
                .map { command -> execute(command) }
    }

    fun execute(commandDescription: CommandDescription) {
        CommandListeners
                .all
                .find { commandListener -> commandListener.matches(commandDescription) }
                .get()
                .execute(commandDescription)
                .block()
    }

    private fun buildCommand(message: Message): CommandDescription {
        val commandDetails = message.content.split(" ")
        return CommandDescription(commandDetails[1], "", message.channel) // todo safe multi optional argument retrieval
    }
}