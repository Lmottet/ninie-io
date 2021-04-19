package com.lmo.ninie.io.services.commands.impl

import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.services.commands.AliasService
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl : AliasService {

    override fun find(alias: String?) = Alias.find(alias + "")

}