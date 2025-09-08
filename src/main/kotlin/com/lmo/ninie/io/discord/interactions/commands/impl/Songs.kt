package com.lmo.ninie.io.discord.interactions.commands.impl

import com.lmo.ninie.io.data.dao.SongDao
import com.lmo.ninie.io.discord.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Songs(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message) = songDao
        .all()
        .map { song -> song.name }
        .reduce { songs, song -> "$songs, $song" }
}