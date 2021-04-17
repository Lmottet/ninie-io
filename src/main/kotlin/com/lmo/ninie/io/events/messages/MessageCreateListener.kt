package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.events.EventListener
import com.lmo.ninie.io.extensions.eventmessage.callsNinie
import com.lmo.ninie.io.extensions.eventmessage.extractCommandAlias
import com.lmo.ninie.io.services.AliasService
import com.lmo.ninie.io.services.CommandService
import discord4j.core.event.domain.message.MessageCreateEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener(
    val commandService: CommandService,
    val aliasService: AliasService
) : EventListener<MessageCreateEvent> {

    @Value("\${bot.prefix}")
    val prefix = ""

    override fun getEventType(): Class<MessageCreateEvent> = MessageCreateEvent::class.java

    override fun execute(event: Mono<MessageCreateEvent>): Mono<Unit>? {
        return event.map { e ->
            val command = aliasService.find(e.message.extractCommandAlias())
            if (e.message.callsNinie(prefix)) {
               commandService.execute(command.getOrElse(Command.UNKNOWN), e.message)
            } else {
//                todo add repeater here
                 Mono.empty()
            }
        }.block()
            ?.map { }
    }

}