package com.phpusr.yandexmusic.playlistexporter.dto

class Out(val playlist: Playlist)

class Playlist(val title: String, val tracks: List<Track>)

class Track(val title: String, val artists: List<Artist>)

class Artist(val name: String)