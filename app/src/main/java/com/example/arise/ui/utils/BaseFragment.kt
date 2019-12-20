package com.example.arise.ui.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.arise.extensions.createFactory
import javax.inject.Inject

abstract class BaseFragment<T : ViewModel>(
    @LayoutRes private val layoutResInput: Int? = null
) : Fragment() {

    @Inject
    lateinit var viewModel: T

    protected var rootView: View? = null

    private var reusedView = false

    @LayoutRes
    open var layoutRes: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        AndroidInjection.inject(this)

        viewModel.let {
            val viewModelFactory = it.createFactory()
            ViewModelProviders.of(this, viewModelFactory).get(it.javaClass)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(layoutResInput != null && layoutRes == null){
            layoutRes = layoutResInput
        }

        if (rootView == null) {
            if (layoutRes != null) {
                layoutRes?.let {
                    rootView = inflater.inflate(it, container, false)
                }

            } else {
                rootView = super.onCreateView(inflater, container, savedInstanceState)
            }
        } else {
            reusedView = true
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(reusedView == false){
            initializeViews()
        }
    }

    open fun inject() {}

    open fun initializeViews(){ }
}