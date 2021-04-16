package com.lmo.ninie.io.commands

import com.lmo.ninie.io.constants.CommandNames
import com.lmo.ninie.io.constants.MagicStrings
import io.vavr.control.Option
import io.vavr.kotlin.option

enum class Command(
    val defaultAlias: String,
    val description: String,
    val manual: String
) {
    ABOUT(
        CommandNames.ABOUT,
        "Describes ninie.io",
        MagicStrings.MANUAL_NONE
    ),
    MEOW(
        CommandNames.MEOW,
        "Say hi !",
        MagicStrings.MANUAL_NONE
    ),
    SING(
        CommandNames.SING,
        "Sing a song of your choice (or random)",
        """
            optional : [song name]
            Pick a song of your choice
        """.trimIndent()
    ),
    SONGS(
        CommandNames.SONGS,
        "All the songs Ninie knows !",
        MagicStrings.MANUAL_NONE
    ),
    HELP(
        CommandNames.HELP,
        "this command, for n00bs. Try 'help help' fore more",
        """
        optional : [command name]
        Details the purpose of a specific command
        """.trimIndent()
    ),
    CRY(
        CommandNames.CRY,
        "Get some compassion",
        MagicStrings.MANUAL_NONE
    ),
    UNKNOWN(
        CommandNames.UNKNOWN,
        "Better admit you don't know than panic",
        "Why would you do this to me"
    ),
    FART(
        CommandNames.FART,
        "Eeeeeeew !",
        "But why ?"
    );

    companion object {
        fun exists(name: String) = find(name).isDefined

        fun find(name: String): Option<Command> = values().find { e -> e.defaultAlias == name }.option()

    }

}