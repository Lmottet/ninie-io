package com.lmo.ninie.io.services.reactions

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import reactor.core.publisher.Mono

interface RespondableMapperService {
    fun reactToCreation(message: Message): Mono<Unit>
    fun reactToUpdate(message: Message): Mono<Unit>
}