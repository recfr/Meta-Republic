package com.retrolabs.metarepublic.utils

import androidx.recyclerview.widget.DiffUtil
import com.retrolabs.metarepublic.data.model.database.MetaDetailsEntity

object Util {

    object MetaComparator : DiffUtil.ItemCallback<MetaDetailsEntity>() {
        override fun areItemsTheSame(oldItem: MetaDetailsEntity, newItem: MetaDetailsEntity): Boolean {
            return oldItem.metaId == newItem.metaId
        }

        override fun areContentsTheSame(oldItem: MetaDetailsEntity, newItem: MetaDetailsEntity): Boolean {
            return oldItem == newItem
        }
    }
}
