package com.lmo.ninie.io.events.message.commands

interface CommandListener {

    fun matches(command: Command): Boolean

    fun execute(command: Command)

}