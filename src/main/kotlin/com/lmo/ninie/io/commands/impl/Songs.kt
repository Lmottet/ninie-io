package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.SONGS
import com.lmo.ninie.io.constants.MagicStrings
import com.lmo.ninie.io.constants.Songs
import discord4j.core.`object`.entity.Message

class Songs : AbstractCommand(
        SONGS,
        "All the songs Ninie knows !",
        MagicStrings.MANUAL_NONE
) {

    override fun response(message: Message) = Songs.all
            .map { song -> song.name() }
            .reduce { songs, song -> "$songs, $song" }

}