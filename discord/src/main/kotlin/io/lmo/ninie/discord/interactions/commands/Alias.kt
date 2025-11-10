package io.lmo.ninie.discord.interactions.commands

import io.lmo.ninie.data.constants.commands.CommandDescriptions
import io.lmo.ninie.data.constants.commands.CommandManuals
import io.lmo.ninie.data.constants.commands.CommandNames

enum class Alias(
    val defaultAlias: String,
    val description: String,
    val manual: String
) {
    About(
        CommandNames.ABOUT,
        CommandDescriptions.ABOUT,
        CommandManuals.MANUAL_NONE
    ),
    Cry(
        CommandNames.CRY,
        CommandDescriptions.CRY,
        CommandManuals.MANUAL_NONE
    ),
    Fart(
        CommandNames.FART,
        CommandDescriptions.FART,
        CommandManuals.MANUAL_NONE
    ),
    Help(
        CommandNames.HELP,
        CommandDescriptions.HELP,
        CommandManuals.HELP
    ),
    Meow(
        CommandNames.MEOW,
        CommandDescriptions.MEOW,
        CommandManuals.MANUAL_NONE
    ),
    Shh(
        CommandNames.SHH,
        CommandDescriptions.SHH,
        CommandManuals.MANUAL_NONE
    ),
    Sing(
        CommandNames.SING,
        CommandDescriptions.SING,
        CommandManuals.SING
    ),
    Songs(
        CommandNames.SONGS,
        CommandDescriptions.SONGS,
        CommandManuals.MANUAL_NONE
    ),
    Unknown(
        CommandNames.UNKNOWN,
        CommandDescriptions.UNKNOWN,
        CommandManuals.UNKNOWN
    )

}
