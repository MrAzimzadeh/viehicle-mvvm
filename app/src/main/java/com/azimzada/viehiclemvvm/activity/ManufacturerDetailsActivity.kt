package com.azimzada.viehiclemvvm.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimzada.viehiclemvvm.adapter.ManufacturerDetailsAdapter
import com.azimzada.viehiclemvvm.databinding.ActivityManufacturerDetailsBinding
import com.azimzada.viehiclemvvm.viewmodel.VehicleViewModel

class ManufacturerDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManufacturerDetailsBinding
    lateinit var viewModel: VehicleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManufacturerDetailsBinding.inflate(layoutInflater)
        binding.manufacturerButton.setOnClickListener {
            startActivity(Intent(this, ManufacturerActivity::class.java))
        }
        setContentView(binding.root)
        binding.manufacturerDetailsRecyclerRow.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this)[VehicleViewModel::class.java]

        binding.searchButton.setOnClickListener {
            viewModel.getManufacturerDetails(this, binding.vehicleTypeEditText.text.toString())
        }

        viewModel.carManufacturerLiveData.observe(this, Observer { VehicleManufacturerDetails ->
            binding.manufacturerDetailsRecyclerRow.adapter =
                viewModel.carManufacturerLiveData.value?.Results?.let {
                    ManufacturerDetailsAdapter(
                        it
                    )
                }
        })
    }
}