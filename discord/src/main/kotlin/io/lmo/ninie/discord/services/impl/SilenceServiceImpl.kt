package io.lmo.ninie.discord.services.impl

import io.lmo.ninie.discord.KnownGuild
import io.lmo.ninie.discord.configuration.BotConfigurationProperties
import io.lmo.ninie.discord.services.SilenceService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class SilenceServiceImpl(private val botConfigurationProperties: BotConfigurationProperties) : SilenceService {
    private val silencedGuilds = mutableMapOf<KnownGuild, LocalDateTime>()

    override fun shouldKeepQuiet(guild: KnownGuild): Boolean {
        val silencedUntil = silencedGuilds[guild] ?: return false
        val isSilent = utcNow() < silencedUntil
        if (!isSilent) silencedGuilds.remove(guild)
        return isSilent
    }

    override fun keepQuiet(guild: KnownGuild) {
        val silence = silencedGuilds[guild] ?: LocalDateTime.now(ZoneOffset.UTC)
        silencedGuilds[guild] = silence.plusHours(botConfigurationProperties.silenceDurationHours)
    }

    private fun utcNow(): LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
}
