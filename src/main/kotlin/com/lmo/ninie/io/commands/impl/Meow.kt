package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.constants.CommandNames.MEOW
import com.lmo.ninie.io.constants.Emojis.HEART
import discord4j.core.`object`.entity.Message

class Meow : AbstractCommand(
        MEOW,
        "Say hi !",
        "Just type it !"
) {

    override fun response(message: Message) = "MEEEEOOOOOOW $HEART"

}
