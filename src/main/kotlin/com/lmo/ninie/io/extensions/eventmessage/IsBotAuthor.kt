package com.lmo.ninie.io.extensions.eventmessage

import discord4j.core.`object`.entity.Message

fun Message.isBotAuthor() =  this.author.map { it.isBot }.orElse(false)