package com.banrossyn.hbl.rainview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banrossyn.hbl.rainview.R
import com.banrossyn.hbl.rainview.customview.EmojiRainLayout

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

      val  emojione = view.findViewById<EmojiRainLayout>(R.id.frist_fragment)


        emojione.addEmoji(R.drawable.e_eye_love)
        emojione.addEmoji(R.drawable.e_eye_love)
        emojione.addEmoji(R.drawable.e_eye_love)
        emojione.addEmoji(R.drawable.e_eye_love)
        emojione.per = 8
        emojione.duration = 4500
        emojione.dropDuration = 2400
        emojione.dropFrequency = 500
        emojione.startDropping()
        return view
    }
}