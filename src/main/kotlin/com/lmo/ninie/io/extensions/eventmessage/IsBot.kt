package com.lmo.ninie.io.extensions.eventmessage

import discord4j.core.`object`.entity.Message

fun Message.isForNinie():Boolean = !this.author.get().isBot && this.content.startsWith("p")