package com.esports.letsbuy.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.util.zip.Inflater

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (Inflater: LayoutInflater) -> VB,
) : Fragment() {
    private var _binding: VB? = null
    val binding: VB get() = _binding as VB

    lateinit var loading: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        loading = ProgressDialog(requireContext())
        allObserver()
        setListener()
        return binding.root
    }

    abstract fun allObserver()

    abstract fun setListener()
}