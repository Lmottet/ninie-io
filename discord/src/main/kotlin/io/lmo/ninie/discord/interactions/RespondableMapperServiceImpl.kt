package io.lmo.ninie.discord.interactions

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.discord.interactions.reactions.CreationReactionService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RespondableMapperServiceImpl(
    private val reactions: List<CreationReactionService>
) : RespondableMapperService {

    override fun reactToCreation(message: Message): Mono<MessageData> =
        reactions.fold(Mono.empty()) { chain, reaction ->
            chain.switchIfEmpty(Mono.defer { reaction.respondTo(message) })
        }
}
