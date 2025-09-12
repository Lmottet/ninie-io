package com.lmo.ninie.io.discord.interactions

import com.lmo.ninie.io.constants.text.Emojis
import com.lmo.ninie.io.discord.eventmessage.isBotAuthor
import com.lmo.ninie.io.discord.interactions.reactions.GreetingService
import com.lmo.ninie.io.discord.interactions.reactions.RandomResponseService
import com.lmo.ninie.io.discord.interactions.reactions.RepeaterService
import com.lmo.ninie.io.discord.interactions.reactions.TriggeredResponseService
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
    val triggeredResponseService: TriggeredResponseService
) : RespondableMapperService {

    override fun reactToCreation(message: Message): Mono<MessageData> {
        return greetingService.respondTo(message)
            .switchIfEmpty(Mono.defer { triggeredResponseService.respondTo(message) })
            .switchIfEmpty(Mono.defer { repeaterService.respondTo(message) })
            .switchIfEmpty(Mono.defer { randomResponseService.respondTo(message) })
    }

    override fun reactToUpdate(message: Message): Mono<Unit> {
        if (message.isBotAuthor())
            return Mono.empty()

        val map = message.addReaction(ReactionEmoji.unicode(Emojis.EYES)).map { }
        return map
    }

}