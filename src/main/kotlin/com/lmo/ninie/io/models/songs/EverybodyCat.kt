package com.lmo.ninie.io.models.songs

import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

class EverybodyCat : Song {

    override fun name(): String = "EverybodyCat"

    override fun sing(channel: MessageChannel): Mono<Message> {
        return channel.createMessage("Everybody wants to be a cat")
    }
}