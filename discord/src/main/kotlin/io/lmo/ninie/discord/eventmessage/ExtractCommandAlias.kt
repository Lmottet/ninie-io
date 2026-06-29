package io.lmo.ninie.discord.eventmessage

import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.constants.text.MagicStrings

fun Message.extractCommandAlias(prefix: String): String =
    this.content.removePrefix(prefix).split(MagicStrings.WHITESPACE).first()