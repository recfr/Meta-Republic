package com.retrolabs.metarepublic.domain.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity

class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    private var favoritesList = emptyList<MetaDetailsEntity>()

    inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
