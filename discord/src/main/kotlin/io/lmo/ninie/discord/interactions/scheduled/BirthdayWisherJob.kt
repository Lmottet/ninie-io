package io.lmo.ninie.discord.interactions.scheduled

import io.lmo.ninie.discord.ScheduledMessage
import discord4j.core.GatewayDiscordClient
import io.lmo.ninie.discord.Channels
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId

@Component
class BirthdayWisherJob(scheduler: TaskScheduler, client: GatewayDiscordClient) : BaseCreateMessageJob(scheduler, client) {

    override fun buildNextMessage(): ScheduledMessage {
        val localDateTime = LocalDateTime.of(2025, 9, 15, 8, 0)
        val zone = ZoneId.of("Europe/Paris")
        val instant = localDateTime.atZone(zone).toInstant()
        return ScheduledMessage(Channels.TeuteuGeneral, instant, "Joyeux ludo-versaire (ben oui il s'appelle pas annie). Fesses (X30 huehuehuehue)")
    }

    private fun scheduledMessages(): List<ScheduledMessage> = listOf()

}
