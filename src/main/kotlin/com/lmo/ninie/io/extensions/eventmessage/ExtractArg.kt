package com.lmo.ninie.io.extensions.eventmessage

import com.lmo.ninie.io.constants.MagicStrings
import discord4j.core.`object`.entity.Message

fun Message.extractArg(argumentNumber: Int): String? {
    val terms = this.content.split(MagicStrings.WHITESPACE)
    val args = terms.subList(2, terms.size)
    val argumentIndex = argumentNumber - 1
    return if (args.size > argumentIndex) args[argumentIndex] else null
}