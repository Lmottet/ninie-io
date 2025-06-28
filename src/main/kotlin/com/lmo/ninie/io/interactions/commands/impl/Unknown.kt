package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.EmbedCommandBase
import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import org.springframework.stereotype.Component

@Component
class Unknown : EmbedCommandBase {

    override fun response(message: Message): EmbedData =
        ImmutableEmbedData
            .builder()
            .image(
                EmbedImageData.builder()
                    .url("https://tenor.com/view/huh-question-question-mark-idk-i-dont-know-gif-9645463476839628303")
                    .build()
            )
            .build()
}