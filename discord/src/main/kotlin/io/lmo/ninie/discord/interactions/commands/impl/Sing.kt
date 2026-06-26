package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.repositories.static.StaticSongRepository
import io.lmo.ninie.discord.eventmessage.extractArg
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class Sing(private val songRepository: StaticSongRepository) : MessageCommandBase {
    override val alias = Alias.Sing

    override fun response(message: Message): String {
        val song = songRepository.find(message.extractArg(1) ?: "")
        return (song ?: songRepository.any()).content
    }
}
