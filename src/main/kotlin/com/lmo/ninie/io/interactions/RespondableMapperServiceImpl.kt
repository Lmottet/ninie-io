package com.lmo.ninie.io.interactions

import com.lmo.ninie.io.constants.text.Emojis
import com.lmo.ninie.io.interactions.reactions.*
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.reaction.ReactionEmoji
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RespondableMapperServiceImpl(
    val greetingService: GreetingService,
    val repeaterService: RepeaterService,
    val randomResponseService: RandomResponseService,
    val laughingService: LaughingService
) : RespondableMapperService {

    override fun reactToCreation(message: Message): Mono<MessageData> {
        return greetingService.respondTo(message)
            .switchIfEmpty(Mono.defer { laughingService.respondTo(message) })
            .switchIfEmpty(Mono.defer { repeaterService.respondTo(message) })
            .switchIfEmpty(Mono.defer { randomResponseService.respondTo(message) })
    }

    override fun reactToUpdate(message: Message): Mono<Unit> = message.addReaction(ReactionEmoji.unicode(Emojis.EYES)).map { }

}