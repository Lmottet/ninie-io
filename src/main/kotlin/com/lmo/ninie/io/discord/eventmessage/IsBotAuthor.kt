package com.lmo.ninie.io.discord.eventmessage

import discord4j.core.`object`.entity.Message

fun Message.isBotAuthor(): Boolean =  this.author.map { it.isBot }.orElse(false)