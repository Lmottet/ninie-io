package io.lmo.ninie.discord.interactions.scheduled

import io.lmo.ninie.discord.ScheduledMessage
import discord4j.core.GatewayDiscordClient
import io.lmo.ninie.data.dao.SongDao
import io.lmo.ninie.discord.Channels
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import kotlin.random.Random

@Component
class RandomSingingJob(scheduler: TaskScheduler, client: GatewayDiscordClient, private val songDao: SongDao) : BaseCreateMessageJob(scheduler, client) {

    override fun buildNextMessage(): ScheduledMessage {
        val delay = Random.nextLong(
            Duration.ofHours(0).toMillis(),
            Duration.ofHours(96).toMillis()
        )
        val instant = Instant.now()
            .plusMillis(Duration.ofHours(72).toMillis())
            .plusMillis(delay)
        return ScheduledMessage(Channels.TeuteuGeneral, instant, songDao.any().content)
    }

}