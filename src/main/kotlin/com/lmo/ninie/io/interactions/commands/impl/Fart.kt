package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.EmbedCommandBase
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import org.springframework.stereotype.Component

@Component
class Fart : EmbedCommandBase {

    override fun response(message: Message): EmbedData =
        ImmutableEmbedData
            .builder()
            .image(
                EmbedImageData.builder()
                    .url("https://media1.tenor.com/images/83fa8e76bf81f674a388d94ec51c0961/tenor.gif?itemid=5050937")
                    .build()
            )
            .build()

}