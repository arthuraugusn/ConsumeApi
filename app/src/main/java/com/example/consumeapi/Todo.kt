package com.example.consumeapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Todo(
    val id:Int,
    val name:String,
    val height:Double,
    val gender:String
)

const val base_url = "https://rawcdn.githack.com/akabab/starwars-api/0.2.1/api/"

interface APIService{
    @GET("id/{idCharacter}.json")
    suspend fun getCharacter(@Path("idCharacter")id: Int): Todo

    companion object{

        fun getApi(): APIService {

            val retrofit = Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()

            val api = retrofit.create(APIService::class.java)

            return api
        }

    }
}
