package io.lmo.ninie.discord.eventmessage

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.constants.text.MagicStrings

fun Message.extractCommandAlias(): String {
    val terms = this.content.replace(MagicStrings.EXCLAMATION, "").split(MagicStrings.WHITESPACE)
    return terms[0]
}