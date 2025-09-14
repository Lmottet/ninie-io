package io.lmo.ninie.discord.interactions.reactions

import io.lmo.ninie.discord.eventmessage.knownGuild
import io.lmo.ninie.discord.interactions.NinieRespondable
import io.lmo.ninie.discord.KnownGuild
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RandomResponseService : NinieRespondable {

    // todo : refactor so that response chances can be fixed to a static %, and then the messages picked (according to the guild)
    override fun respondTo(message: Message): Mono<MessageData> {
        val random = (1..50).random()
        return when (random) {
            41 -> {
                return if (KnownGuild.Teuteu == message.knownGuild()) message.restChannel.createMessage("Peut-être, mais toujours pas de dracthyr chaman !")
                else Mono.empty()
            }

            42 -> message.restChannel.createMessage("NON !")
            43 -> message.restChannel.createMessage(
                ImmutableEmbedData.builder().image(
                        EmbedImageData.builder()
                            .url("https://media4.giphy.com/media/v1.Y2lkPTZjMDliOTUyZnRidnVkaDR2NTZicXFmcjFqOHB3ZzV3bHk4dXZ3cmU5aTBuMnFkMiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/XwiCpwGgyolOIeA4Iw/giphy.gif")
                            .build()
                    ).build()
            )

            else -> Mono.empty()
        }
    }
}
