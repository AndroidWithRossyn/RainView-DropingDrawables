package com.banrossyn.hbl.rainview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banrossyn.hbl.rainview.R
import com.banrossyn.hbl.rainview.customview.EmojiRainLayout

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        val third = inflater.inflate(R.layout.fragment_third, container, false)
       val emojithree = third.findViewById<EmojiRainLayout>(R.id.third_fragment)

        emojithree.addEmoji(R.drawable.e_toung)
        emojithree.addEmoji(R.drawable.e_toung)
        emojithree.addEmoji(R.drawable.e_toung)
        emojithree.addEmoji(R.drawable.e_toung)
        emojithree.per = 8
        emojithree.duration = 4500
        emojithree.dropDuration = 2400
        emojithree.dropFrequency = 500
        emojithree.startDropping()
        return third
    }
}