package com.example.arise.extensions

import androidx.fragment.app.Fragment
import com.example.arise.App
import com.example.arise.di.components.AriseComponent
import com.example.arise.di.modules.AriseModule

fun <T : Fragment> T.ariseComponent() : AriseComponent {
    val mmtravelComponent = (this.activity!!.application as App).appComponent
        .newAriseComponent(AriseModule(requireActivity()))

    return mmtravelComponent
}