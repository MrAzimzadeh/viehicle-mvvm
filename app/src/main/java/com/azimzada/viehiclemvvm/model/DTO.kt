package com.azimzada.viehiclemvvm.model


data class DTO(
    var Country: String,
    var Mfr_CommonName: String?,
    var Mfr_ID: Int,
    var Mfr_Name: String,
    var VehicleTypes: List<VehicleTypesDTO>
)
