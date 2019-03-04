package com.phpusr.yandexmusic.playlistexporter

import com.phpusr.yandexmusic.playlistexporter.parser.JsonPlaylistParser

fun main() {
    JsonPlaylistParser.parse("phpusr", 1077)
}