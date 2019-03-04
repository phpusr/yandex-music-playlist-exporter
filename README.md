# yandex-music-playlist-exporter
Экспортирует плейлисты из Яндекс.Музыки в текстовый файл, и позволяет их импортировать, например в Spotify

## Порядок экспорта

Нужно знать имя пользователя хозяина плейлиста и ID плейлиста, которые можно получить из ссылки на плейлист

Например: "https://music.yandex.ru/users/phpusr/playlists/1077"
 -  Имя пользователя: **phpusr**
 - ID плейлиста: **1077**

Переходим в файл: "**src/main/kotlin/com/phpusr/yandexmusic/playlistexporter/Main.kt**"

Заполняем его нужными данными и запускаем    

    fun main() { 
        JsonPlaylistParser.parse("phpusr", 1077)
    }

Появляется папка "playlists" с txt-файлом нужного плейлиста

Теперь переходим на: https://www.tunemymusic.com/ru/

Нажимаем "**Давайте приступим**", выбираем источник "**Файл**" и выбираем только что полученный файл

Дальше выбираем целевую платформу и импортируем треки