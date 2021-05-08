package com.lmo.ninie.io.interactions.reactions.impl

import com.lmo.ninie.io.interactions.reactions.RespondableMapperService
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RespondableMapperServiceImpl(
    val greetingService: GreetingService,
    val repeaterService: RepeaterService,
    val blankReactionService: BlankReactionService,
    val stalkerService: StalkerService
) : RespondableMapperService {

    override fun reactToCreation(message: Message): Mono<Unit> =
        greetingService.respondTo(message)
            .orElse(repeaterService.respondTo(message))
            .orElse(blankReactionService.respondTo(message))
            .get()
            .map {  }

    override fun reactToUpdate(message: Message): Mono<Unit> =
        stalkerService.respondTo(message)
            .orElse(blankReactionService.respondTo(message))
            .get()
}