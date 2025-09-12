package com.lmo.ninie.io.discord.interactions

import Channels
import com.lmo.ninie.io.data.dao.SongDao
import discord4j.core.GatewayDiscordClient
import discord4j.core.`object`.entity.channel.TextChannel
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import kotlin.random.Random

@Component
class RandomSingingJob(private val scheduler: TaskScheduler, private val client: GatewayDiscordClient, private val songDao: SongDao) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        scheduleNext()
    }

    private fun scheduleNext() {

        val delay = Random.nextLong(
            Duration.ofHours(0).toMillis(),
            Duration.ofHours(96).toMillis()
        )
        val nextInstant = Instant.now()
            .plusMillis(Duration.ofHours(72).toMillis())
            .plusMillis(delay)

        scheduler.schedule({ executeTask() }, nextInstant)
    }

    private fun executeTask() {
        client.getChannelById(Channels.TeuteuGeneral)
            .ofType(TextChannel::class.java)
            .flatMap { channel -> channel.createMessage(songDao.any().content) }
            .subscribe()

        scheduleNext()
    }
}
