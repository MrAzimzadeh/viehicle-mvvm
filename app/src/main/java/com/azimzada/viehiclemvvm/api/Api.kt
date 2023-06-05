package com.azimzada.viehiclemvvm.api

import com.azimzada.viehiclemvvm.model.DTOResult
import com.azimzada.viehiclemvvm.model.GetManufacturerDetailsResults
import com.azimzada.viehiclemvvm.model.GetModelsForMakeYearResult
import com.azimzada.viehiclemvvm.model.ManufacturerResult
import com.azimzada.viehiclemvvm.model.VehicleTypeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("getallmanufacturers")
    fun getVehicleData(@Query("format") format: String): Call<DTOResult>
    @GET("GetManufacturerDetails/{manufacturer}")
    fun getGetManufacturerDetails(
        @Path("manufacturer") manufacturer: String,
        @Query("format") format: String
    ): Call<GetManufacturerDetailsResults>

    @GET("GetMakeForManufacturer/{manufacturer}")
    fun getMakeForManufacturer(
        @Path("manufacturer") manufacturer: String,
        @Query("format") format: String): Call<ManufacturerResult>

    @GET("GetModelsForMakeYear/make/{makeName}/modelyear/{year}")
    fun getModelsForMakeYear(@Path("makeName") makeName: String,
                             @Path("year") year: Int,
                             @Query("format") format: String): Call<GetModelsForMakeYearResult>

    @GET("GetModelsForMakeYear/make/{makeName}/modelyear/{year}/vehicletype/{vehicleType}")
    fun getVehicleType(@Path("makeName") makeName: String,
                       @Path("year") year: Int,
                       @Path("vehicleType") vehicleType: String,
                       @Query("format") format: String): Call<VehicleTypeResult>
}