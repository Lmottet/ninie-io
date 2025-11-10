package io.lmo.ninie.discord.services

import io.lmo.ninie.discord.KnownGuild

interface SilenceService {

    fun shouldKeepQuiet(guild: KnownGuild): Boolean
    fun keepQuiet(guild: KnownGuild)
}