package io.lmo.ninie.discord

import discord4j.common.util.Snowflake

enum class KnownGuild(val id: Snowflake) {
    Teuteu(Snowflake.of("826184542393204826")),
    Doom(Snowflake.of("1433425802568929302")),
    Melio(Snowflake.of("738447743365677087")),
    Nani(Snowflake.of("891629679151292457"));

    companion object {
        @JvmStatic
        fun fromValue(value: Snowflake): KnownGuild? = entries.find { it.id.equals(value) }
    }
}