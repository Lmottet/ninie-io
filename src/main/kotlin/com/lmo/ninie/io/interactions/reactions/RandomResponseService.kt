package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.extensions.eventmessage.knownGuild
import com.lmo.ninie.io.interactions.NinieRespondable
import com.lmo.ninie.io.models.KnownGuild
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RandomResponseService : NinieRespondable {

    override fun respondTo(message: Message): Mono<MessageData> {
        val random = (1..50).random()
        return when (random) {
            41 -> {
                if (message.knownGuild() == KnownGuild.Teuteu)
                    return message.restChannel.createMessage("Peut-être, mais toujours pas de dracthyr chaman !")
                return Mono.empty();
            }

            42 -> message.restChannel.createMessage("NON !")
            43 -> message.restChannel.createMessage(
                ImmutableEmbedData
                    .builder()
                    .image(
                        EmbedImageData.builder()
                            .url("https://media4.giphy.com/media/v1.Y2lkPTZjMDliOTUyZnRidnVkaDR2NTZicXFmcjFqOHB3ZzV3bHk4dXZ3cmU5aTBuMnFkMiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/XwiCpwGgyolOIeA4Iw/giphy.gif")
                            .build()
                    )
                    .build()
            )

            else -> Mono.empty()
        }
    }
}
