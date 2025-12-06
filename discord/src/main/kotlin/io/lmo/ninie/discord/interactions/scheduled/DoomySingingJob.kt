package io.lmo.ninie.discord.interactions.scheduled

import io.lmo.ninie.discord.ScheduledMessage
import discord4j.core.GatewayDiscordClient
import io.lmo.ninie.data.repositories.static.StaticSongRepository
import io.lmo.ninie.discord.Channels
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component

@Component
class DoomySingingJob(scheduler: TaskScheduler, client: GatewayDiscordClient, private val songRepository: StaticSongRepository) :
    BaseCreateMessageJob(scheduler, client), RandomFutureInstant {

    override fun buildNextMessage(): ScheduledMessage =
        ScheduledMessage(Channels.DoomyGeneral, randomInstant(), songRepository.any().content)

}