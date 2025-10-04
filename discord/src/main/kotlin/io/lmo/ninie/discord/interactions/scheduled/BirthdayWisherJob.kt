package io.lmo.ninie.discord.interactions.scheduled

import discord4j.common.util.Snowflake
import io.lmo.ninie.discord.ScheduledMessage
import discord4j.core.GatewayDiscordClient
import io.lmo.ninie.discord.Channels
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Year
import java.time.ZoneId
import kotlin.collections.minByOrNull

@Component
class BirthdayWisherJob(scheduler: TaskScheduler, client: GatewayDiscordClient) : BaseCreateMessageJob(scheduler, client) {
    private val birthdays: List<BirthdayInfo> = listOf(
        BirthdayInfo(9, 15, Channels.TeuteuGeneral, "15 septembre ... 15 septembre ... ça me parle pas ..."),
        BirthdayInfo(10, 6, Channels.TeuteuGeneral, "AUJOURD'HUI C'EST MWAAAAA ! JOYEUX MWANNIVERSAIRE"),
        BirthdayInfo(10, 13, Channels.TeuteuGeneral, "Une année survécue de plus pour la nazi du blé !"),
        BirthdayInfo(6, 28, Channels.TeuteuGeneral, "HA ! On est le 28. Le vieux con. Hehe"),
    )

    override fun buildNextMessage(): ScheduledMessage {
        val nextBirthday = nextBirthday()

        val zone = ZoneId.of("Europe/Paris")
        val instant = LocalDateTime.of(
            nextBirthday.first.year,
            nextBirthday.first.month,
            nextBirthday.first.dayOfYear,
            8,
            0
        ).atZone(zone).toInstant()
        return ScheduledMessage(nextBirthday.second.channel, instant, nextBirthday.second.message)
    }

    private fun nextBirthday(): Pair<LocalDate, BirthdayInfo> {
        val currentYearBirthdays = birthdays
            .map { Pair(LocalDate.of(Year.now().value, it.month, it.day), it) }
            .filter { it.first > LocalDate.now() }
        val nextYearBirthdays = birthdays
            .map { Pair(LocalDate.of(Year.now().value + 1, it.month, it.day), it) }

        return (currentYearBirthdays + nextYearBirthdays).minBy { it.first }
    }

    private data class BirthdayInfo(
        val month: Int,
        val day: Int,
        val channel: Snowflake,
        val message: String
    )
}
