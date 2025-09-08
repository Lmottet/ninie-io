package com.lmo.ninie.io.discord.models

import discord4j.common.util.Snowflake

enum class KnownGuild(val id: Snowflake) {
    Teuteu(Snowflake.of("826184542393294826")),
    Nani(Snowflake.of("891629679151292457"));

    companion object {
        @JvmStatic
        fun fromValue(value: Snowflake): KnownGuild? =
            entries.find { it.id.equals(value) }
    }
}