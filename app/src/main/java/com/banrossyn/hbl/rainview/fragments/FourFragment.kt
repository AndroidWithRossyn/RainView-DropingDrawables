package com.banrossyn.hbl.rainview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banrossyn.hbl.rainview.R
import com.banrossyn.hbl.rainview.customview.EmojiRainLayout

class FourFragment : Fragment() {


    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        val four = inflater.inflate(R.layout.fragment_four, container, false)
       val emojifour = four.findViewById<EmojiRainLayout>(R.id.four_fragment)



        emojifour.addEmoji(R.drawable.e_hand)
        emojifour.addEmoji(R.drawable.e_hand)
        emojifour.addEmoji(R.drawable.e_hand)
        emojifour.addEmoji(R.drawable.e_hand)
        emojifour.per = 8
        emojifour.duration = 4500
        emojifour.dropDuration = 2400
        emojifour.dropFrequency = 500
        emojifour.startDropping()
        return four
    }
}