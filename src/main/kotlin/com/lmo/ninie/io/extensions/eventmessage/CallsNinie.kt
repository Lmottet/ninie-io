package com.lmo.ninie.io.extensions.eventmessage

import com.lmo.ninie.io.constants.text.MagicStrings
import discord4j.core.`object`.entity.Message

fun Message.callsNinie(prefix:String) :Boolean{
    val terms = this.content.split(MagicStrings.WHITESPACE)
    return (terms.size > 1) && prefix == terms[0]
}