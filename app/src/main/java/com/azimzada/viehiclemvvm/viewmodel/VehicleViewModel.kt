package com.azimzada.viehiclemvvm.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azimzada.viehiclemvvm.Constants
import com.azimzada.viehiclemvvm.api.Api
import com.azimzada.viehiclemvvm.model.DTOResult
import com.azimzada.viehiclemvvm.model.GetManufacturerDetailsResults
import com.azimzada.viehiclemvvm.model.GetModelsForMakeYearResult
import com.azimzada.viehiclemvvm.model.ManufacturerResult
import com.azimzada.viehiclemvvm.model.VehicleTypeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehicleViewModel: ViewModel() {
    lateinit var api: Api
    var carLiveData = MutableLiveData<DTOResult>()
    var carManufacturerLiveData = MutableLiveData<GetManufacturerDetailsResults>()
    var manufacturerLiveData = MutableLiveData<ManufacturerResult>()
    var byYearLiveData = MutableLiveData<GetModelsForMakeYearResult>()
    var vehicleTypeLiveData = MutableLiveData<VehicleTypeResult>()

    fun getVehicle(context: Context) {
        api = Constants.getApi()
        api.getVehicleData(Constants.FORMAT).enqueue(object : Callback<DTOResult> {
            override fun onResponse(call: Call<DTOResult>, response: Response<DTOResult>) {
                val data: DTOResult? = response.body()
                this@VehicleViewModel.carLiveData.postValue(data)
            }

            override fun onFailure(call: Call<DTOResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })

    }


    fun getManufacturerDetails(context: Context, carType: String) {
        api = Constants.getApi()
        api.getGetManufacturerDetails(carType, Constants.FORMAT)
            .enqueue(object : Callback<GetManufacturerDetailsResults> {
                override fun onResponse(
                    call: Call<GetManufacturerDetailsResults>,
                    response: Response<GetManufacturerDetailsResults>
                ) {
                    val data: GetManufacturerDetailsResults? = response.body()
                    this@VehicleViewModel.carManufacturerLiveData.postValue(data)
                }

                override fun onFailure(call: Call<GetManufacturerDetailsResults>, t: Throwable) {
                    Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
                }
            })
    }

    fun getMakeForManufacturerDetails(context: Context, manufacturer: String) {
        api = Constants.getApi()
        api.getMakeForManufacturer(manufacturer, Constants.FORMAT).enqueue(object : Callback<ManufacturerResult> {
            override fun onResponse(call: Call<ManufacturerResult>, response: Response<ManufacturerResult>) {
                val data: ManufacturerResult? = response.body()
                this@VehicleViewModel.manufacturerLiveData.postValue(data)
            }

            override fun onFailure(call: Call<ManufacturerResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })
    }
    fun getModelsForMakeYearDetails(context: Context, makeName: String, modelyear:String) {
        api = Constants.getApi()
        val year:Int = modelyear.toInt()
        api.getModelsForMakeYear(makeName, year, Constants.FORMAT).enqueue(object : Callback<GetModelsForMakeYearResult> {
            override fun onResponse(
                call: Call<GetModelsForMakeYearResult>,
                response: Response<GetModelsForMakeYearResult>
            ) {
                //val data: List<GetModelsForMakeYear>? = response.body()?.Results
                /* if(data?.isEmpty() == true){

                 }*/
                val data: GetModelsForMakeYearResult? = response.body()
                this@VehicleViewModel.byYearLiveData.postValue(data)
            }

            override fun onFailure(call: Call<GetModelsForMakeYearResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun getVehicleType(context: Context, makeName: String, modelyear:String, vehicleType:String) {
        api = Constants.getApi()
        val year:Int = modelyear.toInt()
        api.getVehicleType(makeName, year, vehicleType, Constants.FORMAT).enqueue(object : Callback<VehicleTypeResult> {
            override fun onResponse(call: Call<VehicleTypeResult>, response: Response<VehicleTypeResult>) {
                val data: VehicleTypeResult? = response.body()
                this@VehicleViewModel.vehicleTypeLiveData.postValue(data)
            }

            override fun onFailure(call: Call<VehicleTypeResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })
    }


}