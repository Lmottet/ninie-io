package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.events.EventListener
import com.lmo.ninie.io.extensions.eventmessage.callsNinie
import com.lmo.ninie.io.extensions.eventmessage.extractCommandAlias
import com.lmo.ninie.io.services.commands.AliasService
import com.lmo.ninie.io.services.reactions.ReactionMapperService
import discord4j.core.`object`.entity.Message
import discord4j.core.event.domain.message.MessageCreateEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener(
    val reactionMapperService: ReactionMapperService,
    val aliasService: AliasService,
    val unknown: Alias.Unknown
) : EventListener<MessageCreateEvent> {

    @Value("\${bot.prefix}")
    val prefix = ""

    override fun getEventType(): Class<MessageCreateEvent> = MessageCreateEvent::class.java

    override fun execute(event: Mono<MessageCreateEvent>): Mono<Unit>? = event.map { execute(it.message) }
        .block()
        ?.map { }

    private fun execute(message: Message) =
        if (message.callsNinie(prefix)) executeCommand(message) else executeReaction(message)

    private fun executeCommand(message: Message): Mono<Unit> =
        findCommand(message).commandService()
            .respondTo(message)
            .get()

    private fun executeReaction(message: Message): Mono<Unit> =
        reactionMapperService.reactToCreation(message)

    private fun findCommand(message: Message): Alias =
        aliasService.find(message.extractCommandAlias())
            .getOrElse(unknown)

}