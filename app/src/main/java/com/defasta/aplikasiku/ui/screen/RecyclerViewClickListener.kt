package com.defasta.aplikasiku.ui.screen

import android.view.View
import com.defasta.aplikasiku.data.response.Search
import com.defasta.aplikasiku.ui.model.ModelSepeda

interface RecyclerViewClickListener {
    fun onItemClicked(view: View, modelSepeda: ModelSepeda)

    fun onItemMovieClicked(view: View, itemMovie: Search)
}