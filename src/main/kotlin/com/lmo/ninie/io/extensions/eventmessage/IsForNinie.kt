package com.lmo.ninie.io.extensions.eventmessage

import com.lmo.ninie.io.constants.MagicStrings
import discord4j.core.`object`.entity.Message

fun Message.isForNinie(prefix: String): Boolean =
        !this.author.get().isBot
                && this.content.startsWith(prefix + MagicStrings.WHITESPACE)