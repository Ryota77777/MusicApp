package com.example.talkerbanda.playlist

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.talkerbanda.R
import com.example.talkerbanda.playlist.TrackAdapter.TrackViewHolder
import com.example.talkerbanda.playlist.Track

class TrackAdapter(private val context: Context) : RecyclerView.Adapter<TrackViewHolder>() {

    private var tracks: List<Track> = emptyList()
    private var mediaPlayer: MediaPlayer? = null
    private var handler: Handler? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = tracks[position]
        holder.bind(track)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    fun updateData(newTracks: List<Track>) {
        tracks = newTracks
        notifyDataSetChanged()
    }

    inner class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val trackName: TextView = itemView.findViewById(R.id.track_name)
        private val trackArtist: TextView = itemView.findViewById(R.id.track_artist)
        private val btnPlay: ImageButton = itemView.findViewById(R.id.btn_play)
        private val btnPause: ImageButton = itemView.findViewById(R.id.btn_pause)
        private val btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
        private val seekBar: SeekBar = itemView.findViewById(R.id.seek_bar)

        fun bind(track: Track) {
            trackName.text = track.name
            trackArtist.text = track.artist

            btnPlay.setOnClickListener {
                if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.pause()
                    btnPlay.visibility = View.VISIBLE
                    btnPause.visibility = View.GONE
                } else {
                    startMediaPlayer(track.audioResId)
                }
            }

            btnPause.setOnClickListener {
                if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.pause()
                    btnPlay.visibility = View.VISIBLE
                    btnPause.visibility = View.GONE
                } else {
                    mediaPlayer?.start()
                    btnPlay.visibility = View.GONE
                    btnPause.visibility = View.VISIBLE
                    setupSeekBar()
                }
            }

            btnDelete.setOnClickListener {
                // Реализация удаления трека
            }
        }

        private fun startMediaPlayer(audioResId: Int) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, audioResId)
            mediaPlayer?.start()
            btnPlay.visibility = View.GONE
            btnPause.visibility = View.VISIBLE
            setupSeekBar()
        }

        private fun setupSeekBar() {
            mediaPlayer?.let { player ->
                seekBar.visibility = View.VISIBLE
                seekBar.max = player.duration

                handler = Handler()
                handler?.postDelayed(object : Runnable {
                    override fun run() {
                        if (player.isPlaying) {
                            seekBar.progress = player.currentPosition
                            handler?.postDelayed(this, 1000) // Обновление каждую секунду
                        }
                    }
                }, 0)
            }
        }
    }
}











