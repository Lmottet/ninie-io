package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.constants.CommandListeners
import com.lmo.ninie.io.extensions.eventmessage.extractAction
import com.lmo.ninie.io.extensions.eventmessage.isForNinie
import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface MessageListener {

    fun processEvent(eventMessage: Message, prefix:String): Mono<Unit> {
        return Mono
                .just(eventMessage)
                .filter { eventMessage.isForNinie(prefix) }
                .map { message -> CommandListeners.find(eventMessage.extractAction()) }
                .map { command ->
                    command.execute(eventMessage).block()
                    return@map
                }
    }

}