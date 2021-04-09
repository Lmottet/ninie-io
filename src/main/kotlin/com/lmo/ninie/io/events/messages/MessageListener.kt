package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.singletons.CommandListeners
import com.lmo.ninie.io.extensions.eventmessage.extractAction
import com.lmo.ninie.io.extensions.eventmessage.isForNinie
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import reactor.core.publisher.Mono

interface MessageListener {

    fun processEvent(eventMessage: Message, prefix:String): Mono<MessageData?> {
        return Mono
                .just(eventMessage)
                .filter { eventMessage.isForNinie(prefix) }
                .map { message -> CommandListeners.find(eventMessage.extractAction()).response(message)}
                .map { response -> eventMessage.restChannel.createMessage(response).block() }
    }

}