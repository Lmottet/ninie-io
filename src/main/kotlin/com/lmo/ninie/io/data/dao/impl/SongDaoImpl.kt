package com.lmo.ninie.io.data.dao.impl

import com.lmo.ninie.io.data.repositories.SongRepository
import com.lmo.ninie.io.data.dao.SongDao
import com.lmo.ninie.io.discord.models.songs.Song
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SongDaoImpl(
    val songRepository: SongRepository
) : SongDao {

    override fun find(name: String): Song? = songRepository.find(name)

    override fun any(): Song = songRepository.any()

    override fun all(): List<Song> = songRepository
        .all()
        .stream()
        .collect(Collectors.toList())
}