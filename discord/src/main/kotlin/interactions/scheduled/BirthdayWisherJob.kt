package com.lmo.ninie.io.discord.interactions

import ScheduledMessage
import discord4j.core.GatewayDiscordClient
import interactions.scheduled.BaseCreateMessageJob
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId

@Component
class BirthdayWisherJob(scheduler: TaskScheduler, client: GatewayDiscordClient) : BaseCreateMessageJob(scheduler, client) {

    override fun buildNextMessage(): ScheduledMessage {
        val localDateTime = LocalDateTime.of(2025, 9, 15, 12, 0)
        val zone = ZoneId.of("Europe/Paris")
        val instant = localDateTime.atZone(zone).toInstant()
        return ScheduledMessage(Channels.TeuteuGeneral, instant, "Joyeux versaire")
    }

    private fun scheduledMessages(): List<ScheduledMessage> = listOf()

}
