package com.hani.mediaplayer.mediacontrol

interface MediaPlayelistener {

    fun onPlaybackStateChanged()

    fun onPlaybackPositionChanged(position: Int)

}