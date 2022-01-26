package com.retrolabs.metarepublic.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.retrolabs.metarepublic.databinding.FragmentDetailBinding
import com.retrolabs.metarepublic.ui.DetailFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

//@HiltViewModel
//class DetailFragmentViewModel @Inject constructor(
//    private val detailFragmentArgs: DetailFragmentArgs,
//    @ApplicationContext val context: Context
//) : ViewModel() {
//
//    private val _metaNameViewModel = MutableLiveData<String>()
//    val metaNameViewModel
//        get() = _metaNameViewModel
//
//    private val _metaMediaViewModel = MutableLiveData<String>()
//    val metaMediaViewModel
//        get() = _metaMediaViewModel
//
//
//    fun setUi(view: FragmentDetailBinding) {
//
//        view.apply {
//            Glide.with(context).load(detailFragmentArgs.argsMetaMedia).into(imageViewDetailsFragment)
//            textViewTitleDetailsFragment.text = detailFragmentArgs.argsMetaName
//            textViewTokenNameDetailsFragment.text = detailFragmentArgs.argsTokenName
//            textViewDetailsDetailsFragment.text = detailFragmentArgs.argsMetaInfo
//        }
//    }
//}