package io.lmo.ninie.discord.interactions.commands.impl

import io.lmo.ninie.discord.interactions.commands.EmbedCommandBase
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
                    .url("https://media2.giphy.com/media/v1.Y2lkPTZjMDliOTUyZDRwN2V5aTgxYTB1bnNtMXAycXM1MjI2MDRreW8zeGNlZGZiOWwwbCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/xT0xeuOy2Fcl9vDGiA/giphy.gif")
                    .build()
            )
            .build()
}
