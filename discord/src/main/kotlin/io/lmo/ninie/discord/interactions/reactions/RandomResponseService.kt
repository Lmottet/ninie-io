package io.lmo.ninie.discord.interactions.reactions

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.EmbedImageData
import discord4j.discordjson.json.ImmutableEmbedData
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.discord.KnownGuild
import io.lmo.ninie.discord.eventmessage.knownGuild
import io.lmo.ninie.discord.interactions.reactions.RandomEntry.EmbedEntry
import io.lmo.ninie.discord.interactions.reactions.RandomEntry.TextEntry
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
@Order(4)
class RandomResponseService : CreationReactionService {

    companion object {
        private const val TRIGGER_DENOMINATOR = 50
        private val ENTRIES: List<RandomEntry> = listOf(
            TextEntry(
                text = "Peut-être, mais toujours pas de dracthyr chaman !",
                guilds = setOf(KnownGuild.Teuteu, KnownGuild.Doom)
            ),
            TextEntry(text = "NON !"),
            EmbedEntry(imageUrl = "https://media4.giphy.com/media/v1.Y2lkPTZjMDliOTUyZnRidnVkaDR2NTZicXFmcjFqOHB3ZzV3bHk4dXZ3cmU5aTBuMnFkMiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/XwiCpwGgyolOIeA4Iw/giphy.gif"),
        )
    }

    override fun respondTo(message: Message): Mono<MessageData> {
        if ((1..TRIGGER_DENOMINATOR).random() != 1) return Mono.empty()

        val guild = message.knownGuild()
        val eligible = ENTRIES.filter { entry ->
            val guilds = entry.guilds
            guilds == null || (guild != null && guild in guilds)
        }
        val entry = eligible.randomOrNull() ?: return Mono.empty()

        return when (entry) {
            is TextEntry -> message.restChannel.createMessage(entry.text)
            is EmbedEntry -> message.restChannel.createMessage(
                ImmutableEmbedData.builder()
                    .image(EmbedImageData.builder().url(entry.imageUrl).build())
                    .build()
            )
        }
    }
}
