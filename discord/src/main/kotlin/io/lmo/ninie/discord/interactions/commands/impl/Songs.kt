package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.repositories.static.StaticSongRepository
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class Songs(val songRepository: StaticSongRepository) : MessageCommandBase {

    override fun response(message: Message) = songRepository
        .all()
        .map { song -> song.name }
        .reduce { songs, song -> "$songs, $song" }
}