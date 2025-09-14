package io.lmo.ninie.discord

import discord4j.common.util.Snowflake
import java.time.Instant

data class ScheduledMessage(
    val channelId: Snowflake,
    val schedule: Instant,
    val message:String
)