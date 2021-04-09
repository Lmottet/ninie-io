package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.ABOUT
import discord4j.core.`object`.entity.Message

class About : AbstractCommand(
        ABOUT,
        "Describes ninie-io",
        "Just type it"
) {
    override fun response(message: Message): String =  """
        Ninie-io is a discord bot, written in kotlin.
        More on : https://github.com/Lmottet/ninie-io
        """.trimIndent()

}