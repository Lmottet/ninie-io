package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.UNKNOWN
import discord4j.core.`object`.entity.Message

class Unknown : AbstractCommand(
        UNKNOWN,
        "Better admit you don't know than panic",
        "Why would you do this to me"
) {

    override fun response(message: Message) = "Unknown command"
}