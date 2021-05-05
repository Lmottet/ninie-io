package com.lmo.ninie.io.interactions

import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import reactor.core.publisher.Mono

interface NinieRespondable<T> {

    fun respondTo(message: Message): Option<Mono<T>>

}