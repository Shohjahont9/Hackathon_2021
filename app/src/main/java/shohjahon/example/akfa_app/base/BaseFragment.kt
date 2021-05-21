package com.example.note.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {
    protected open var binding: T? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = this.setBinding(inflater, container)
        return binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    abstract fun setBinding(inflater: LayoutInflater, container: ViewGroup?): T
}