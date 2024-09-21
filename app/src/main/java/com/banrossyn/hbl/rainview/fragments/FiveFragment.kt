package com.banrossyn.hbl.rainview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.banrossyn.hbl.rainview.R
import com.banrossyn.hbl.rainview.customview.EmojiRainLayout

class FiveFragment : Fragment() {


    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        val five = inflater.inflate(R.layout.fragment_five, container, false)
       val emojifive = five.findViewById<EmojiRainLayout>(R.id.five_fragment)

        emojifive.addEmoji(R.drawable.e_bday)
        emojifive.addEmoji(R.drawable.e_bday)
        emojifive.addEmoji(R.drawable.e_bday)
        emojifive.addEmoji(R.drawable.e_bday)

        emojifive.per = 8
        emojifive.duration = 4500
        emojifive.dropDuration = 2400
        emojifive.dropFrequency = 500
        emojifive.startDropping()
        return five
    }
}