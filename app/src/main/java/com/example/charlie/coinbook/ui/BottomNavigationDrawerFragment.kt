package com.example.charlie.coinbook.ui

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.coinbook.R

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    val mTag : String = BottomNavigationDrawerFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

}