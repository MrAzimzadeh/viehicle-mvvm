package com.azimzada.viehiclemvvm.model

data class DTOResult(
    var Count: Int,
    var Message: String,
    var SearchCriteria: String,
    var Results: List<DTO>
)
