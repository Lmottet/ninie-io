package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractMessageCommand
import com.lmo.ninie.io.constants.Songs
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Songs : AbstractMessageCommand() {

    override fun response(message: Message) = Songs.all
        .map { song -> song.name() }
        .reduce { songs, song -> "$songs, $song" }
}