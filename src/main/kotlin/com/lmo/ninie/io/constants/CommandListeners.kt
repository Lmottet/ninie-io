package com.lmo.ninie.io.constants

import com.lmo.ninie.io.commands.impl.*
import com.lmo.ninie.io.commands.impl.Songs
import com.lmo.ninie.io.extensions.eventmessage.extractAction
import discord4j.core.`object`.entity.Message
import io.vavr.kotlin.hashSet

object CommandListeners {
    val all = hashSet(
            Help(),
            Sing(),
            Meow(),
            Songs(),
            About(),
            Cry()
    )

    fun find(commandName: String) = all
            .find { commandListener -> commandName == commandListener.commandName() }
            .get()
}