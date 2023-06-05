package com.azimzada.viehiclemvvm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimzada.viehiclemvvm.activity.ManufacturerDetailsActivity
import com.azimzada.viehiclemvvm.adapter.Adapter
import com.azimzada.viehiclemvvm.databinding.ActivityMainBinding
import com.azimzada.viehiclemvvm.viewmodel.VehicleViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: VehicleViewModel

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.skipButton.setOnClickListener {
            startActivity(Intent(this, ManufacturerDetailsActivity::class.java))
        }
        setContentView(binding.root)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this)[VehicleViewModel::class.java]

        viewModel.getVehicle(this@MainActivity)

        viewModel.carLiveData.observe(this, Observer { CarData ->
            binding.recyclerView.adapter = viewModel.carLiveData.value?.Results?.let {
                Adapter(
                    it
                )
            }
        })
    }

}