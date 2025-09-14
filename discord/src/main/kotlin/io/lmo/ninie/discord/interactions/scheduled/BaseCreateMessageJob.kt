package io.lmo.ninie.discord.interactions.scheduled

import io.lmo.ninie.discord.ScheduledMessage
import discord4j.core.GatewayDiscordClient
import discord4j.core.`object`.entity.channel.TextChannel
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.scheduling.TaskScheduler

abstract class BaseCreateMessageJob(private val scheduler: TaskScheduler, private val client: GatewayDiscordClient) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) = scheduleNext()

    private fun scheduleNext() {
        val scheduledMessage = buildNextMessage()
        scheduler.schedule({ executeTask(scheduledMessage) }, scheduledMessage.schedule)
    }

    private fun executeTask(scheduledMessage: ScheduledMessage) {
        client.getChannelById(scheduledMessage.channelId)
            .ofType(TextChannel::class.java)
            .flatMap { channel -> channel.createMessage(scheduledMessage.message) }
            .subscribe()

        scheduleNext()
    }

    abstract fun buildNextMessage(): ScheduledMessage

}
