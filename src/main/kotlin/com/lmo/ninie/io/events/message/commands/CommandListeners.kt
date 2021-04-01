package com.lmo.ninie.io.events.message.commands

import com.lmo.ninie.io.events.message.commands.impl.Help
import io.vavr.collection.Set
import io.vavr.kotlin.hashSet

object CommandListeners {
    val all: Set<CommandListener> = hashSet(
            Help()
    )
}