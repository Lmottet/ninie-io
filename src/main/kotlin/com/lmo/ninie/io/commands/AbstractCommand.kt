package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message

abstract class AbstractCommand() {
    abstract fun respondTo(message: Message): String
}