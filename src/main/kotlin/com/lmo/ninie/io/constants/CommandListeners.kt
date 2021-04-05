package com.lmo.ninie.io.constants

import com.lmo.ninie.io.commands.impl.Help
import com.lmo.ninie.io.commands.impl.Meow
import com.lmo.ninie.io.commands.impl.Sing
import com.lmo.ninie.io.commands.impl.Songs
import io.vavr.kotlin.hashSet

object CommandListeners {
    val all = hashSet(
            Help(),
            Sing(),
            Meow(),
            Songs()
    )
}