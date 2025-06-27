package com.lmo.ninie.io.extensions.eventmessage

import com.lmo.ninie.io.constants.text.MagicStrings
import discord4j.core.`object`.entity.Message

fun Message.extractCommandAlias(): String {
    val terms = this.content.replace(MagicStrings.EXCLAMATION, "").split(MagicStrings.WHITESPACE)
    return terms[0]
}