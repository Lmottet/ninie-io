package com.lmo.ninie.io.commands

import com.lmo.ninie.io.constants.commands.CommandDescriptions
import com.lmo.ninie.io.constants.commands.CommandManuals
import com.lmo.ninie.io.constants.commands.CommandNames

sealed class Alias(
    val defaultAlias: String,
    val description: String,
    val manual: String
) {

    class About : Alias(
        CommandNames.ABOUT,
        CommandDescriptions.ABOUT,
        CommandManuals.MANUAL_NONE
    )

    class Cry : Alias(
        CommandNames.CRY,
        CommandDescriptions.CRY,
        CommandManuals.MANUAL_NONE
    )

    class Fart : Alias(
        CommandNames.FART,
        CommandDescriptions.FART,
        CommandManuals.MANUAL_NONE
    )

    class Help : Alias(
        CommandNames.HELP,
        CommandDescriptions.HELP,
        CommandManuals.HELP
    )

    class Meow : Alias(
        CommandNames.MEOW,
        CommandDescriptions.MEOW,
        CommandManuals.MANUAL_NONE
    )

    class Sing : Alias(
        CommandNames.SING,
        CommandDescriptions.SING,
        CommandManuals.SING
    )

    class Songs : Alias(
        CommandNames.SONGS,
        CommandDescriptions.SONGS,
        CommandManuals.MANUAL_NONE
    )

    class Unknown : Alias(
        CommandNames.UNKNOWN,
        CommandDescriptions.UNKNOWN,
        CommandManuals.UNKNOWN
    )

}
