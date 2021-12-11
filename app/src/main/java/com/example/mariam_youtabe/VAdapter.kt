package com.example.mariam_youtabe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.video_item.view.*

class VAdapter (   private val videoList: Array<Array<Any>>,
private val player: YouTubePlayer
) : RecyclerView.Adapter<VAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: ImageButton = itemView.btnVideo
        val myTextView: TextView = itemView.btnT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.video_item,
            parent, false
        )
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val curTitle = videoList[position][0]
        val curLink = videoList[position][1]
        val link = curLink.toString()
        val curCov = videoList[position][2]
        holder.myTextView.text = curTitle as String?
        holder.button.setBackgroundResource(curCov as Int)
        holder.button.setOnClickListener {
            player.loadVideo(link , 0f)
        }
    }

    override fun getItemCount() = videoList.size


}