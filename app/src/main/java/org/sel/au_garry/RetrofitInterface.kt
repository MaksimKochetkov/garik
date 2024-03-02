package org.sel.au_garry

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("characters")
    fun pers(): Call<CharDataclass>
}