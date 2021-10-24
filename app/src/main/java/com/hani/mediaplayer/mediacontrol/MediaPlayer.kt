package com.hani.mediaplayer.mediacontrol

interface MediaPlayer {

    fun addMedia(audioDataItem: AudioDataItem)
    fun addMediaFiles(audioFiles: ArrayList<AudioDataItem>)
    fun prepare(mediaIndex :Int)
    fun play()
    fun pause()
    fun seekTo(position : Long)
    fun release()
    fun next()
    fun previous()
    fun getCurrentMedia() : AudioDataItem;
}