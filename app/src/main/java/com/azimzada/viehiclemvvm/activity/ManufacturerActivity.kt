package com.azimzada.viehiclemvvm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimzada.viehiclemvvm.R
import com.azimzada.viehiclemvvm.adapter.ManufacturerAdapter
import com.azimzada.viehiclemvvm.databinding.ActivityManufacturerBinding
import com.azimzada.viehiclemvvm.viewmodel.VehicleViewModel

class ManufacturerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManufacturerBinding
    lateinit var viewModel: VehicleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManufacturerBinding.inflate(layoutInflater)
        binding.manufacturerSkipButton.setOnClickListener {
            startActivity(Intent(this, ModelsForMakeYearActivity::class.java))
        }
        setContentView(binding.root)
        binding.manufacturerRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this)[VehicleViewModel::class.java]

        binding.manufacturerSearch.setOnClickListener {
            viewModel.getMakeForManufacturerDetails(this, binding.manufacturerEditText.text.toString())
        }

        viewModel.manufacturerLiveData.observe(this, Observer { manufacturerDetails ->
            binding.manufacturerRecyclerView.adapter = viewModel.manufacturerLiveData.value?.Results?.let {
                ManufacturerAdapter(
                    this, it
                )
            }
        })
    }
}