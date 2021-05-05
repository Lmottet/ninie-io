package com.lmo.ninie.io.interactions.reactions.impl

import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BlankReactionService : NinieRespondable<Unit> {
    override fun respondTo(message: Message): Option<Mono<Unit>> = Option.of(Mono.empty())
}