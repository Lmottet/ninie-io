package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import com.lmo.ninie.io.dao.SongDao
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Songs(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message) = songDao
        .all()
        .map { song -> song.name }
        .reduce { songs, song -> "$songs, $song" }
}