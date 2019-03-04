package com.phpusr.yandexmusic.playlistexporter.parser

import org.jsoup.Jsoup
import java.io.File

fun main() {
    val doc = Jsoup.parse(File("playlists/i_like_it.html"), "utf8")
    val blocks = doc.select(".d-track_in-lib")

    blocks.forEach {
        val nameBlock = it.select(".d-track__name > a").first()
        println(nameBlock.text())
    }
}