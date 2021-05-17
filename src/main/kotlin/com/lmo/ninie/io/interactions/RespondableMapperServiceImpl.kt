package com.lmo.ninie.io.interactions

import com.lmo.ninie.io.interactions.reactions.*
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RespondableMapperServiceImpl(
    val greetingService: GreetingService,
    val repeaterService: RepeaterService,
    val blankReactionService: BlankReactionService,
    val stalkerService: StalkerService,
    val disagreementService: DisagreementService
) : RespondableMapperService {

    override fun reactToCreation(message: Message): Mono<Unit> =
        greetingService.respondTo(message)
            .orElse(repeaterService.respondTo(message))
            .orElse(disagreementService.respondTo(message))
            .orElse(blankReactionService.respondTo(message))
            .get()
            .map {  }

    override fun reactToUpdate(message: Message): Mono<Unit> =
        stalkerService.respondTo(message)
            .orElse(blankReactionService.respondTo(message))
            .get()
}