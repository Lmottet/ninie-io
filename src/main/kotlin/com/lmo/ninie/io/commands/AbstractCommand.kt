package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message

abstract class AbstractCommand(private val command: Command) {
    abstract fun respondTo(message: Message): String

    fun describe() = command.description
}