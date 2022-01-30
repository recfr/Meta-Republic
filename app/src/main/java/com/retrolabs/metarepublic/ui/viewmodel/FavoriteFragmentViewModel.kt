package com.retrolabs.metarepublic.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.retrolabs.metarepublic.domain.repository.FavoriteRepositoryImpl
import javax.inject.Inject

class FavoriteFragmentViewModel @Inject constructor(private val favoriteRepositoryImpl: FavoriteRepositoryImpl) : ViewModel() {


}