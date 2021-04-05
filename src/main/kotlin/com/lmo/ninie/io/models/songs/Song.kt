package com.lmo.ninie.io.models.songs

import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

interface Song {
    fun name() : String

    fun sing(channel : MessageChannel): Mono<Message>
}