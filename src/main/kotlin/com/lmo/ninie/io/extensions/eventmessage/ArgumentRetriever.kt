package com.lmo.ninie.io.extensions.eventmessage

import discord4j.core.`object`.entity.Message

fun Message.extractArg(index: Int): String {
    val terms = this.content.split(" ")
    return terms.subList(2, terms.size)[index]
}