package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RandomResponseService : NinieRespondable {

    override fun respondTo(message: Message): Mono<MessageData> {
        val random =(1..50).random()
        return when (random) {
            42 -> message.restChannel.createMessage("NON !")
            43 -> message.restChannel.createMessage( ImmutableEmbedData
                .builder()
                .image(
                    EmbedImageData.builder()
                        .url("https://giphy.com/gifs/claynosaurz-3d-dinosaur-clayno-XwiCpwGgyolOIeA4Iw")
                        .build()
                )
                .build())
            else -> Mono.empty()
        }
    }
}
