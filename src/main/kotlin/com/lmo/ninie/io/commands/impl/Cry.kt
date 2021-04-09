package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.CRY
import discord4j.core.`object`.entity.Message

class Cry : AbstractCommand(
        CRY,
        "Get some compassion",
        "Just type it !"
) {
    override fun response(message: Message) = "There there ! *pat* *pat*"
}