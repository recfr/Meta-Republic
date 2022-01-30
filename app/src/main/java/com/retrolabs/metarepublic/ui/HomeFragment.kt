package com.retrolabs.metarepublic.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.retrolabs.metarepublic.databinding.FragmentHomeBinding
import com.retrolabs.metarepublic.domain.recyclerview.MetaverseAdapter
import com.retrolabs.metarepublic.ui.viewmodel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModels()
    private val metaverseAdapter = MetaverseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        with(binding) {
            recyclerview.adapter = metaverseAdapter
            recyclerview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.metaModelLiveData.observe(viewLifecycleOwner, { metaModelEntityList ->
            metaverseAdapter.setData(metaModelEntityList)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
