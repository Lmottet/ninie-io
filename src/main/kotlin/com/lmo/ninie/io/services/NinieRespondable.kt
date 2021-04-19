package com.lmo.ninie.io.services

import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import reactor.core.publisher.Mono

interface NinieRespondable {

    fun respondTo(message: Message): Option<Mono<Unit>>

}