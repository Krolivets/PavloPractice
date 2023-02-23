package com.pavlo.pavlopractice.featurelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavlo.pavlopractice.models.Feature

class FeatureListViewModel : ViewModel() {
    val featureListLD = MutableLiveData<List<Feature>>()

    init {
        featureListLD.value = Feature.values().toList()
    }
}
