package com.banrossyn.hbl.rainview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banrossyn.hbl.rainview.R
import com.banrossyn.hbl.rainview.customview.EmojiRainLayout

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        val second = inflater.inflate(R.layout.fragment_second, container, false)
        val emojitwo = second.findViewById<EmojiRainLayout>(R.id.second_fragment)


        emojitwo.addEmoji(R.drawable.e_love)
        emojitwo.addEmoji(R.drawable.e_love)
        emojitwo.addEmoji(R.drawable.e_love)
        emojitwo.addEmoji(R.drawable.e_love)
        emojitwo.addEmoji(R.drawable.e_love)

        emojitwo.per = 8
        emojitwo.duration = 4500
        emojitwo.dropDuration = 2400
        emojitwo.dropFrequency = 500
        emojitwo.startDropping()
        return second
    }
}