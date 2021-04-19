package com.lmo.ninie.io.services.reactions.impl

import com.lmo.ninie.io.services.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import reactor.core.publisher.Mono

class RepeaterService : NinieRespondable {
    override fun respondTo(message: Message): Option<Mono<Unit>> = Option.none()

}
