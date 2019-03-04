package com.phpusr.yandexmusic.playlistexporter.parser

import com.google.gson.Gson
import com.phpusr.yandexmusic.playlistexporter.dto.Out
import java.io.File
import java.net.URL

/**
 * Download playlist from Yandex.Music and parse it into txt file
 */
object JsonPlaylistParser {
    private const val TuneMyMusicUrl = "https://www.tunemymusic.com/ru/"
    private const val PlaylistURL = "https://music.yandex.ru/handlers/playlist.jsx"
    private const val PlaylistsDirName = "playlists"

    fun parse(username: String, playlistId: Int) {
        val json = URL("$PlaylistURL?owner=$username&kinds=$playlistId").readText()
        val out = Gson().fromJson(json, Out::class.java)

        File(PlaylistsDirName).mkdir()
        val outFileName = "$username - ${out.playlist.title}.txt"
        val outTxtFile = File("$PlaylistsDirName/$outFileName")
        outTxtFile.delete()

        out.playlist.tracks.forEach { track ->
            outTxtFile.appendText("${track.artists.joinToString{ it.name }} - ${track.title}\n")
        }

        println("> Found ${out.playlist.tracks.size} tracks in playlist \"$username - ${out.playlist.title}\"")
        println(" - Go to: $TuneMyMusicUrl, select option \"File\" and import the file: \"${outTxtFile.absoluteFile}\"")
    }
}
