package com.lmo.ninie.io.interactions

import com.lmo.ninie.io.constants.text.Channels
import com.lmo.ninie.io.dao.SongDao
import discord4j.common.util.Snowflake
import discord4j.core.GatewayDiscordClient
import discord4j.core.`object`.entity.channel.TextChannel
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.scheduling.TaskScheduler
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import java.util.concurrent.ThreadLocalRandom

@Component
class RandomSingingJob(private val scheduler: TaskScheduler, private val client: GatewayDiscordClient, private val songDao: SongDao) : ApplicationRunner {

    private val random = ThreadLocalRandom.current()

    override fun run(args: ApplicationArguments?) {
        scheduleNext()
    }

    private fun scheduleNext() {
        val minMillis = Duration.ofHours(96).toMillis()
        val delay = minMillis + random.nextLong(Duration.ofHours(72).toMillis() - minMillis)

        val nextInstant = Instant.now().plusMillis(delay)
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
