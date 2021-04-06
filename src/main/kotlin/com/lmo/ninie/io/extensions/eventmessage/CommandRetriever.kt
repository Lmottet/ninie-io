package com.lmo.ninie.io.extensions.eventmessage

import com.lmo.ninie.io.constants.MagicStrings
import discord4j.core.`object`.entity.Message

fun Message.extractAction() = this.content.split(MagicStrings.WHITESPACE)[1]