package io.lmo.ninie.discord.interactions.commands

import io.lmo.ninie.discord.interactions.NinieRespondable

interface CommandBase : NinieRespondable {
    val alias: Alias
    val description: String
    val manual: String
}
