package io.lmo.ninie.discord.interactions.scheduled

import java.time.Duration
import java.time.Instant
import kotlin.random.Random

interface RandomFutureInstant {

    fun randomInstant(): Instant {
        val delay = Random.nextLong(
            Duration.ofHours(0).toMillis(),
            Duration.ofHours(96).toMillis()
        )
        return Instant.now()
            .plusMillis(Duration.ofHours(72).toMillis())
            .plusMillis(delay)
    }
}