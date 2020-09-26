package com.example.workoutcircuit.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.workoutcircuit.CircuitsData

class BaseVM(app: Application): AndroidViewModel(app) {
    val circuitsLiveData = MutableLiveData<MutableList<CircuitsData>>()
    val errorLiveData = MutableLiveData<String>()

    private val circuitsData = arrayListOf(
        CircuitsData("Circuit1"),
        CircuitsData("Circuit2"),
        CircuitsData("Circuit3"),
        CircuitsData("Circuit4"),
        CircuitsData("Circuit5"),
        CircuitsData("Circuit6"),
        CircuitsData("Circuit7"),
        CircuitsData("Circuit8"),
        CircuitsData("Circuit9"),
        CircuitsData("Circuit10"),
        CircuitsData("Circuit11"),
        CircuitsData("Circuit12"),
        CircuitsData("Circuit13"),
        CircuitsData("Circuit14"),
        CircuitsData("Circuit15")
    )

    fun getCircuitData() {
        circuitsLiveData.postValue(circuitsData)
    }
}