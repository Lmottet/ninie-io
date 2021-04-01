package com.lmo.ninie.io.events.message

import com.lmo.ninie.io.events.message.commands.Command
import com.lmo.ninie.io.events.message.commands.CommandListeners
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

interface MessageListener {

    fun processEvent(eventMessage: Message): Mono<Unit> {
        return Mono.just(eventMessage)
                .filter { message -> !message.author.get().isBot && message.content.startsWith("prefix") }
                .map(this::buildCommand)
                .map { command -> execute(command, eventMessage.channel) }
    }

    fun execute(command: Command, channel: Mono<MessageChannel>) {
        return CommandListeners.all.find { commandListener -> commandListener.matches(command) }
                .get()
                .execute(command, channel)
    }

    private fun buildCommand(message: Message): Command {
        val commandDetails = message.content.split(" ")
        return Command(commandDetails[1], "") // todo safe multi optional argument retrieval
    }
}