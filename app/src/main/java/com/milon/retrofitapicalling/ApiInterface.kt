package com.milon.retrofitapicalling

import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET

interface ApiInterface {

      @GET("gimme")
      fun getMeme() : Call<responseDataModel>
}