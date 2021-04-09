package com.lmo.ninie.io.commands

import discord4j.core.`object`.entity.Message

abstract class AbstractCommand (
        val name:String,
        val description:String,
        val man:String
        ){
    abstract fun response(message:Message):String
}