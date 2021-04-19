package com.lmo.ninie.io.commands

import com.lmo.ninie.io.constants.commands.CommandDescriptions
import com.lmo.ninie.io.constants.commands.CommandManuals
import com.lmo.ninie.io.constants.commands.CommandNames
import com.lmo.ninie.io.services.NinieRespondable
import io.vavr.control.Option
import io.vavr.kotlin.option

sealed class Alias(
    val defaultAlias: String,
    val description: String,
    val manual: String
) {

    abstract fun commandService(): NinieRespondable

    class About(
        private val about: com.lmo.ninie.io.commands.impl.About
    ) : Alias(
        CommandNames.ABOUT,
        CommandDescriptions.ABOUT,
        CommandManuals.MANUAL_NONE
    ) {
        override fun commandService(): NinieRespondable = about
    }

    class Cry(
        private val cry: com.lmo.ninie.io.commands.impl.Cry
    ) : Alias(
        CommandNames.CRY,
        CommandDescriptions.CRY,
        CommandManuals.MANUAL_NONE
    ) {
        override fun commandService(): NinieRespondable = cry
    }

    class Fart(
        private val fart: com.lmo.ninie.io.commands.impl.Fart
    ) : Alias(
        CommandNames.FART,
        CommandDescriptions.FART,
        CommandManuals.MANUAL_NONE
    ) {
        override fun commandService(): NinieRespondable = fart
    }

    class Help(
        private val help: com.lmo.ninie.io.commands.impl.Help
    ) : Alias(
        CommandNames.HELP,
        CommandDescriptions.HELP,
        CommandManuals.HELP
    ) {
        override fun commandService(): NinieRespondable = help
    }

    class Meow(
        private val meow: com.lmo.ninie.io.commands.impl.Meow
    ) : Alias(
        CommandNames.MEOW,
        CommandDescriptions.MEOW,
        CommandManuals.MANUAL_NONE
    ) {
        override fun commandService(): NinieRespondable = meow
    }

    class Sing(
        private val aboutService: com.lmo.ninie.io.commands.impl.Sing
    ) : Alias(
        CommandNames.SING,
        CommandDescriptions.SING,
        CommandManuals.SING
    ) {
        override fun commandService(): NinieRespondable = aboutService
    }

    class Songs(
        private val aboutService: com.lmo.ninie.io.commands.impl.Songs
    ) : Alias(
        CommandNames.SONGS,
        CommandDescriptions.SONGS,
        CommandManuals.MANUAL_NONE
    ) {
        override fun commandService(): NinieRespondable = aboutService
    }

    class Unknown(
        private val aboutService: com.lmo.ninie.io.commands.impl.Songs
    ) : Alias(
        CommandNames.UNKNOWN,
        CommandDescriptions.UNKNOWN,
        CommandManuals.UNKNOWN
    ) {
        override fun commandService(): NinieRespondable = aboutService
    }

    companion object {
        fun find(name: String): Option<Alias> = all()
            .find { e -> e.defaultAlias == name }
            .option()

        fun all(): List<Alias> = Alias::class.nestedClasses.map { it.objectInstance as Alias }
    }
}