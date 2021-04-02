package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.models.commands.Command
import com.lmo.ninie.io.commands.CommandListeners
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface MessageListener {

    fun processEvent(eventMessage: Message): Mono<Unit> {
        return Mono
                .just(eventMessage)
                .filter { message -> !message.author.get().isBot && message.content.startsWith("^") }
                .map {message -> buildCommand(message)}
                .map { command -> execute(command) }
    }

    fun execute(command: Command) {
        CommandListeners
                .all
                .find { commandListener -> commandListener.matches(command) }
                .get()
                .execute(command)
                .block()
    }

    private fun buildCommand(message: Message): Command {
        val commandDetails = message.content.split(" ")
        return Command(commandDetails[1], "", message.channel) // todo safe multi optional argument retrieval
    }
}