package com.retrolabs.metarepublic.domain.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.retrolabs.metarepublic.R
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity
import com.retrolabs.metarepublic.databinding.AdapterItemMetaverseBinding
import com.retrolabs.metarepublic.ui.HomeFragmentDirections
import javax.inject.Inject


class MetaverseAdapter @Inject constructor(private val setFavorite: (MetaDetailsEntity) -> Unit) :
    RecyclerView.Adapter<MetaverseAdapter.MetaverseViewHolder>() {

    private var metaverseList = emptyList<MetaDetailsEntity>()

    inner class MetaverseViewHolder(val binding: AdapterItemMetaverseBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                navigateToDetails(metaverseList, it)
            }
        }

        fun bind(metaDetailsEntity: MetaDetailsEntity) {

            binding.let {
                Glide.with(itemView.context).load(metaDetailsEntity.metaMedia).into(it.imageViewThumbnail)
                it.textViewMetaverseName.text = metaDetailsEntity.metaName
                it.textViewToken.text = metaDetailsEntity.metaTokenName
                it.textViewInfo.text = metaDetailsEntity.metaInfo

            }
        }

        //TODO home Fragment !
        private fun navigateToDetails(metaverseList: List<MetaDetailsEntity>, itemView: View) {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                metaverseList[adapterPosition].metaMedia!!,
                metaverseList[adapterPosition].metaName!!,
                metaverseList[adapterPosition].metaUri!!,
                metaverseList[adapterPosition].metaTokenName!!,
                metaverseList[adapterPosition].metaInfo!!
            )

            itemView.findNavController().navigate(action)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetaverseViewHolder {
        return MetaverseViewHolder(
            AdapterItemMetaverseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MetaverseViewHolder, position: Int) {
        val item = metaverseList[position]
        holder.bind(item)

        holder.binding.imageViewFavorite.setImageDrawable(
            ResourcesCompat.getDrawable(
                holder.itemView.context.resources,
                if (item.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border, null
            )
        )

        holder.binding.imageViewFavorite.setOnClickListener {
            if (item.isFavorite) {
                setFavorite.invoke(
                    MetaDetailsEntity(
                        item.metaId, item.metaName, item.metaUri, item.metaTokenName, item.metaMedia, item.metaInfo, false))
            } else {
                setFavorite.invoke(
                    MetaDetailsEntity(
                        item.metaId, item.metaName, item.metaUri, item.metaTokenName, item.metaMedia, item.metaInfo, true))
            }
        }
    }

    override fun getItemCount(): Int {
        return metaverseList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<MetaDetailsEntity>) {
        metaverseList = newList
        notifyDataSetChanged()
    }
}
