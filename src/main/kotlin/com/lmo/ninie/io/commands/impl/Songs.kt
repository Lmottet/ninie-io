package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.Songs
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Songs : AbstractCommand() {

    override fun respondTo(message: Message) = Songs.all
        .map { song -> song.name() }
        .reduce { songs, song -> "$songs, $song" }
}