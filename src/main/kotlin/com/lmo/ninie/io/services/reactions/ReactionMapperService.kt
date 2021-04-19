package com.lmo.ninie.io.services.reactions

import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface ReactionMapperService {
    fun reactToCreation(message: Message): Mono<Unit>
    fun reactToUpdate(message: Message): Mono<Unit>
}