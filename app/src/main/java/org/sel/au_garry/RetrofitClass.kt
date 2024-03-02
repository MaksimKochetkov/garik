package org.sel.au_garry

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {
    fun getRetrofit(): Retrofit=Retrofit.Builder()
        .baseUrl("https://harry-potter-api-en.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}