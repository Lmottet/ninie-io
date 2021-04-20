package com.lmo.ninie.io.services

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.vavr.control.Option
import reactor.core.publisher.Mono

interface NinieRespondable<T> {

    fun respondTo(message: Message): Option<Mono<T>>

}