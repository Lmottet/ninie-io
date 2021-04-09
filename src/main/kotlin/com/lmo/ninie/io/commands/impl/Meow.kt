package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.MEOW
import com.lmo.ninie.io.constants.Emojis.HEART
import com.lmo.ninie.io.constants.MagicStrings
import discord4j.core.`object`.entity.Message

class Meow : AbstractCommand(
        MEOW,
        "Say hi !",
        MagicStrings.MANUAL_NONE
) {

    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"

}
