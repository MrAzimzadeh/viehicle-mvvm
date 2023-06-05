package com.azimzada.viehiclemvvm

import com.azimzada.viehiclemvvm.api.Api
import com.azimzada.viehiclemvvm.network.RetrofitClient

class Constants {
    companion object{
        val BASE_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/"
        var FORMAT = "json"
        fun getApi(): Api {
            return RetrofitClient.getClient(BASE_URL).create(Api::class.java)
        }
    }
}