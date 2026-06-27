package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedData
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.EmbedCommandBase
import org.springframework.stereotype.Component

@Component
class Unknown : EmbedCommandBase {
    override val alias = Alias.Unknown
    override val description = "Better admit you don't know than panic"
    override val manual = "Why would you do this to me"

    override fun response(message: Message): EmbedData =
        ImmutableEmbedData.builder()
            .image(EmbedImageData.builder().url("https://media2.giphy.com/media/v1.Y2lkPTZjMDliOTUyZDRwN2V5aTgxYTB1bnNtMXAycXM1MjI2MDRreW8zeGNlZGZiOWwwbCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/xT0xeuOy2Fcl9vDGiA/giphy.gif").build())
            .build()
}
