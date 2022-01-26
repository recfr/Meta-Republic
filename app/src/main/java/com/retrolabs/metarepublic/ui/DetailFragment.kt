package com.retrolabs.metarepublic.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.retrolabs.metarepublic.databinding.FragmentDetailBinding


lateinit var media: String
lateinit var metaName: String
lateinit var metaUri: String
lateinit var tokenName: String
lateinit var metaInfo: String

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: DetailFragmentViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        media = DetailFragmentArgs.fromBundle(requireArguments()).argsMetaMedia
        metaName = DetailFragmentArgs.fromBundle(requireArguments()).argsMetaName
        metaUri = DetailFragmentArgs.fromBundle(requireArguments()).argsMetaUri
        tokenName = DetailFragmentArgs.fromBundle(requireArguments()).argsTokenName
        metaInfo = DetailFragmentArgs.fromBundle(requireArguments()).argsMetaInfo

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.setUi(binding!!)

        binding.apply {
            Glide.with(requireContext()).load(media).into(imageViewDetailsFragment)

            textViewTitleDetailsFragment.text = metaName
            textViewTokenNameDetailsFragment.text = tokenName
            textViewDetailsDetailsFragment.text = metaInfo


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
