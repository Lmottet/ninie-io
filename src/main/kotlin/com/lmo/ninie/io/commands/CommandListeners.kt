package com.lmo.ninie.io.commands

import com.lmo.ninie.io.commands.impl.Help
import com.lmo.ninie.io.commands.impl.Meow
import com.lmo.ninie.io.commands.impl.Sing
import com.lmo.ninie.io.commands.impl.Songs
import io.vavr.collection.Set
import io.vavr.kotlin.hashSet

object CommandListeners {
    val all: Set<Command> = hashSet(
            Help(),
            Sing(),
            Meow(),
            Songs()
    )
}