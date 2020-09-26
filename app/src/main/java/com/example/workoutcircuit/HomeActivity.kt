package com.example.workoutcircuit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutcircuit.base.BaseVM
import com.example.workoutcircuit.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var homeAdapter: HomeAdapter? = null
    private lateinit var viewModel: BaseVM
    lateinit var list: ArrayList<CircuitsData>
    private val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
    }


    private fun setUpView() {
        binding.apply {
            /** recycler view set up */
            listCircuitsRv.apply {
                layoutManager = LinearLayoutManager(this@HomeActivity)
                adapter = HomeAdapter()
            }

            /** set up view model and observer */
            viewModel = ViewModelProvider(this@HomeActivity).get(BaseVM::class.java)

            /** setup observers */
            setUpObservers()
            viewModel.getCircuitData()
        }
    }

    private fun setUpObservers() {
        viewModel.circuitsLiveData.observe(this, Observer {
            homeAdapter?.submitList(it.toMutableList())
        })

        viewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this@HomeActivity, it, Toast.LENGTH_SHORT).show()
        })
    }
}