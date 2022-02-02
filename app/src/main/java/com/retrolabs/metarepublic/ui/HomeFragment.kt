package com.retrolabs.metarepublic.ui

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.retrolabs.metarepublic.R
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

//        val setFavorite: (MetaDetailsEntity) -> Unit = { viewModel.insertFavorite(it) }

        with(binding) {

//            recyclerview.adapter = MetaverseAdapter(setFavorite)
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
//            metaverseAdapter.MetaverseViewHolder().binding.imageViewFavorite.setOnClickListener { }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.nav_menu, menu)
    }
}
