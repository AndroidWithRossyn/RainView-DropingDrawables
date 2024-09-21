package com.banrossyn.hbl.rainview.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position : Int) : Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourFragment()
            4 -> FiveFragment()
            else -> FirstFragment()
        }
    }

    override fun getCount() : Int {
        return 5
    }

    override fun getPageTitle(position : Int) : CharSequence? {
        var title : String? = null
        if (position == 0) {
            title = "\uD83D\uDE0D"
        } else if (position == 1) {
            title = "\uD83E\uDD70"
        } else if (position == 2) {
            title = "\uD83D\uDE1D"
        } else if (position == 3) {
            title = "\uD83E\uDD2D"
        } else if (position == 4) {
            title = "\uD83E\uDD73"
        }
        return title
    }
}