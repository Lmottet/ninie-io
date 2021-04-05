package com.lmo.ninie.io.extensions.eventmessage

import discord4j.core.`object`.entity.Message
import io.vavr.control.Option

fun Message.extractArg(argumentNumber: Int): Option<String> {
    val terms = this.content.split(" ")
    val args = terms.subList(2, terms.size)
    val argumentIndex = argumentNumber - 1
    return if (args.size > argumentIndex) {
        Option.of(args[argumentIndex])
    } else {
        Option.none()
    }
}