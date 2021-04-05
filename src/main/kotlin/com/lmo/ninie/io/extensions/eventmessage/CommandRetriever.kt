package com.lmo.ninie.io.extensions.eventmessage

import discord4j.core.`object`.entity.Message

fun Message.extractAction() = this.content.split(" ")[1]