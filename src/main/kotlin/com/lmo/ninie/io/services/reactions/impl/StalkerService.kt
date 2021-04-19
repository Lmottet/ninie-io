package com.lmo.ninie.io.services.reactions.impl

import com.lmo.ninie.io.services.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class StalkerService : NinieRespondable {
    override fun respondTo(message: Message): Option<Mono<Unit>> = Option.none()
}