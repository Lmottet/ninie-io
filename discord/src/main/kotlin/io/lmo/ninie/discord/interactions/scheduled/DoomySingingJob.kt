package io.lmo.ninie.discord.interactions.scheduled

import io.lmo.ninie.discord.ScheduledMessage
import discord4j.core.GatewayDiscordClient
import io.lmo.ninie.data.dao.SongDao
import io.lmo.ninie.discord.Channels
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component

@Component
class DoomySingingJob(scheduler: TaskScheduler, client: GatewayDiscordClient, private val songDao: SongDao) :
    BaseCreateMessageJob(scheduler, client), RandomFutureInstant {

    override fun buildNextMessage(): ScheduledMessage =
        ScheduledMessage(Channels.DoomyGeneral, randomInstant(), songDao.any().content)

}