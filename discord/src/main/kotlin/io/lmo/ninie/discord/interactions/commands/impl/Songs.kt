package io.lmo.ninie.discord.interactions.commands.impl

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.dao.SongDao
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import org.springframework.stereotype.Component

@Component
class Songs(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message) = songDao
        .all()
        .map { song -> song.name }
        .reduce { songs, song -> "$songs, $song" }
}