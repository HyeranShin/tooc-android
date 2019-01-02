package com.hyeran.android.travely_user.model

data class StoreResponseData (
        var address : String,
        var closeTime : String,
        var currentBag : Int,
        var grade : Double,
        var latitude : Double,
        var limit : Int,
        var longitude : Double,
        var openTime : String,
        var ownerIdx : Int,
        var restWeekResponseDtos : ArrayList<RestWeekResponseData>,
        var reviewResponseDtos : ArrayList<ReviewResponseData>,
        var storeCall : String,
        var storeIdx : Int,
        var storeImageResponseDtos : ArrayList<StoreImageResponseData>,
        var storeName : String,
        var storeUrl : String
)