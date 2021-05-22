package uz.fizmasoft.xatlov.network

import retrofit2.http.*
import shohjahon.example.akfa_app.network.response.expiredResponse.ExpiredResponse
import shohjahon.example.akfa_app.network.response.loginResponse.LogiResponse

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("users/login")
    suspend fun login(
        @Body data: String,
    ): LogiResponse


    @Headers("Content-Type: application/json")
    @GET("analysis/saw/expired")
    suspend fun expired(
        @Header("token") token: String,
    ): ExpiredResponse



}