package com.lmo.ninie.io.commands

import com.lmo.ninie.io.constants.commands.CommandDescriptions
import com.lmo.ninie.io.constants.commands.CommandManuals
import com.lmo.ninie.io.constants.commands.CommandNames
import io.vavr.control.Option
import io.vavr.kotlin.option

enum class Command(
    val defaultAlias: String,
    val description: String,
    val manual: String
) {
    ABOUT(CommandNames.ABOUT, CommandDescriptions.ABOUT, CommandManuals.MANUAL_NONE),
    MEOW(CommandNames.MEOW, CommandDescriptions.MEOW, CommandManuals.MANUAL_NONE),
    SING(CommandNames.SING, CommandDescriptions.SING, CommandManuals.SING),
    SONGS(CommandNames.SONGS, CommandDescriptions.SONGS, CommandManuals.MANUAL_NONE),
    HELP(CommandNames.HELP, CommandDescriptions.HELP, CommandManuals.HELP),
    CRY(CommandNames.CRY, CommandDescriptions.CRY, CommandManuals.MANUAL_NONE),
    UNKNOWN(CommandNames.UNKNOWN, CommandDescriptions.UNKNOWN, CommandManuals.UNKNOWN),
    FART(CommandNames.FART, CommandDescriptions.FART, CommandManuals.MANUAL_NONE);

    companion object {
        fun find(name: String): Option<Command> = values().find { e -> e.defaultAlias == name }.option()
    }

}