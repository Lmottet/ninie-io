package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.constants.CommandNames.UNKNOWN
import discord4j.core.`object`.entity.Message

class Unknown : Command {
    override fun commandName() = UNKNOWN

    override fun description() = "Better admit you don't know than panic"

    override fun man() = "Why would you do this to me"

    override fun execute(eventMessage: Message) =
            eventMessage.
                    channel.
                    flatMap { chan -> chan.createMessage("Unknown command") }
}