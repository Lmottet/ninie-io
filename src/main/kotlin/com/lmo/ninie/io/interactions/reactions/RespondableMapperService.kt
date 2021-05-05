package com.lmo.ninie.io.interactions.reactions

import discord4j.core.`object`.entity.Message
import reactor.core.publisher.Mono

interface RespondableMapperService {
    fun reactToCreation(message: Message): Mono<Unit>
    fun reactToUpdate(message: Message): Mono<Unit>
}