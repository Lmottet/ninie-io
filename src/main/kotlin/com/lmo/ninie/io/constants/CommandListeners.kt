package com.lmo.ninie.io.constants

import com.lmo.ninie.io.commands.AbstractCommand
import com.lmo.ninie.io.commands.impl.*
import com.lmo.ninie.io.commands.impl.Songs
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

    fun find(commandName: String?): AbstractCommand = all
            .find { commandListener -> commandName == commandListener.name }
            .getOrElse(Unknown())
}