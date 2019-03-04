package com.phpusr.yandexmusic.playlistexporter.parser

import com.google.gson.Gson
import com.phpusr.yandexmusic.playlistexporter.dto.Out
import java.io.File
import java.net.URL

object JsonPlaylistParser {
    private const val TuneMyMusic = "https://www.tunemymusic.com/ru/"

    fun parse(username: String, playlistId: Int) {
        val json = URL("https://music.yandex.ru/handlers/playlist.jsx?owner=$username&kinds=$playlistId").readText()
        val out = Gson().fromJson(json, Out::class.java)

        val outTxtFile = File("${out.playlist.title}.txt")
        outTxtFile.delete()

        out.playlist.tracks.forEachIndexed { index, track ->
            outTxtFile.appendText("${track.artists.joinToString{ it.name }} - ${track.title}\n")
        }

        println("> Found ${out.playlist.tracks.size} tracks from \"${out.playlist.title}\"")
        println(" - Go to: $TuneMyMusic and select option \"file\" and import the file: \"${outTxtFile.absoluteFile}\"")
    }
}
