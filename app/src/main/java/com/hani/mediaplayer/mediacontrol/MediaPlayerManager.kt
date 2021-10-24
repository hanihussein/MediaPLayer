package com.hani.mediaplayer.mediacontrol

import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.ExoPlayer


class MediaPlayerManager(context: Context) : MediaPlayer, Player.Listener {
    private val MEDIA_STORGE_DATA_NAME = "AD_PROJECT"
    private var player: SimpleExoPlayer? = null
    private val mediaList = ArrayList<AudioDataItem>()
    private var currentMediaIndex = -1;
    private val dataSourceFactory = DefaultDataSourceFactory(context, MEDIA_STORGE_DATA_NAME)
    private val extractorsFactory = DefaultExtractorsFactory()


    init {
        val renderersFactory = DefaultRenderersFactory(context)
        val trackSelectionFactory = AdaptiveTrackSelection.Factory()
        val trackSelectSelector = DefaultTrackSelector(context, trackSelectionFactory)
        player = SimpleExoPlayer.Builder(context, renderersFactory, extractorsFactory)
            .setTrackSelector(trackSelectSelector)
            .build()
        player?.addListener(this)
    }


    override fun addMedia(audioDataItem: AudioDataItem) {
        mediaList.add(audioDataItem)
    }

    override fun addMediaFiles(audioFiles: ArrayList<AudioDataItem>) {
        mediaList.addAll(audioFiles)
    }

    override fun prepare(mediaIndex: Int) {
        player?.let {

            currentMediaIndex = mediaIndex

            val mediaSource = ProgressiveMediaSource
                .Factory(dataSourceFactory, extractorsFactory)
                .createMediaSource(MediaItem.fromUri(mediaList[mediaIndex].path)).mediaItem

            it.setMediaItem(mediaSource);
            it.prepare()
        }
    }

    override fun play() {
        player?.play()
    }

    override fun pause() {
        player?.pause()
    }

    override fun seekTo(position: Long) {
        player?.seekTo(position)
    }

    override fun release() {
        player?.release()
    }

    override fun next() {
        if (player?.hasNextWindow() == true)
            player?.seekToNext()
    }

    override fun previous() {
        player?.seekToPrevious()

    }

    override fun getCurrentMedia(): AudioDataItem = mediaList[currentMediaIndex]


    override fun onPlaybackStateChanged(@Player.State playbackState: Int) {

        when (playbackState) {
            ExoPlayer.STATE_BUFFERING -> {
            }
            ExoPlayer.STATE_IDLE -> {
            }
            ExoPlayer.STATE_READY -> {
            }
            ExoPlayer.STATE_ENDED -> {
            }
        }
    }

    override fun onPlayerError(error: PlaybackException) {
        Log.e("onPlayerError", error.message.toString())
    }

    override fun onTracksChanged(
        trackGroups: TrackGroupArray,
        trackSelections: TrackSelectionArray
    ) {
        super.onTracksChanged(trackGroups, trackSelections)
    }

}