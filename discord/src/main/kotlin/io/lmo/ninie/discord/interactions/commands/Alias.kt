package io.lmo.ninie.discord.interactions.commands

enum class Alias(val defaultAlias: String, val description: String, val manual: String) {
    About("about", "Learn more about ninie.io", "Just type it !"),
    Cry("cry", "Get some compassion", "Just type it !"),
    Fart("fart", "Eeeeeeew !", "Just type it !"),
    Help("help", "This command, for n00bs. Try 'help help' fore more", "optional : [command name]\nPick a command you wish to learn more about"),
    Meow("meow", "Say hi !", "Just type it !"),
    Shh("shh", "Get some tea", "Just type it !"),
    Sing("sing", "Sing a song of your choice (or random)", "optional : [song name]\nPick a song of your choice"),
    Songs("songs", "All the songs Ninie knows !", "Just type it !"),
    Unknown("unknown", "Better admit you don't know than panic", "Why would you do this to me")
}
