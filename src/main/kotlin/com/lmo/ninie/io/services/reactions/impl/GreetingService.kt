package com.lmo.ninie.io.services.reactions.impl

import com.lmo.ninie.io.services.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.vavr.control.Option
import reactor.core.publisher.Mono

class GreetingService : NinieRespondable<Unit> {
    override fun respondTo(message: Message): Option<Mono<Unit>> = Option.none()
}