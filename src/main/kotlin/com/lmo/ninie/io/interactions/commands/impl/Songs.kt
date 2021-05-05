package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import com.lmo.ninie.io.services.dao.SongService
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Songs(val songService: SongService) : MessageCommandBase {

    override fun response(message: Message) = songService
        .all()
        .map { song -> song.name }
        .reduce { songs, song -> "$songs, $song" }
}