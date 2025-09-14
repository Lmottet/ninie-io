package io.lmo.ninie.data.dao.impl

import io.lmo.ninie.data.dao.SongDao
import io.lmo.ninie.data.repositories.SongRepository
import io.lmo.ninie.data.songs.Song
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SongDaoImpl(val songRepository: SongRepository) : SongDao {

    override fun find(name: String): Song? = songRepository.find(name)

    override fun any(): Song = songRepository.any()

    override fun all(): List<Song> = songRepository
        .all()
        .stream()
        .collect(Collectors.toList())
}