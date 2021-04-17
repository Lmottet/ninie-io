package com.lmo.ninie.io.services.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.services.AliasService
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl : AliasService {

    override fun find(alias: String?) = Command.find(alias + "")

}