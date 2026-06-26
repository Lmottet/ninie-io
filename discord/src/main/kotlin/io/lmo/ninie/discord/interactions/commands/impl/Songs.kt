package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.repositories.static.StaticSongRepository
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class Songs(private val songRepository: StaticSongRepository) : MessageCommandBase {
    override val alias = Alias.Songs

    override fun response(message: Message) = songRepository.all()
        .joinToString(", ") { it.name }
}
