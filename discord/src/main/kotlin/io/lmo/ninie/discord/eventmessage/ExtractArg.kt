package io.lmo.ninie.discord.eventmessage

import io.lmo.ninie.data.constants.text.MagicStrings
import discord4j.core.`object`.entity.Message

fun Message.extractArg(argumentNumber: Int): String? {
    if (!this.content.contains(MagicStrings.WHITESPACE)) return null

    val terms = this.content.split(MagicStrings.WHITESPACE)
    val args = terms.subList(1, terms.size)
    return if (args.size >= argumentNumber) args[argumentNumber -1] else null
}