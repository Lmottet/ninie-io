package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.CRY
import com.lmo.ninie.io.constants.MagicStrings.MANUAL_NONE
import discord4j.core.`object`.entity.Message

class Cry : AbstractCommand(
        CRY,
        "Get some compassion",
        MANUAL_NONE
) {
    override fun response(message: Message) = "There there ! *pat* *pat*"
}