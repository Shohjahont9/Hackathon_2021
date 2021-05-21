package uz.fizmasoft.xatlov.network

import retrofit2.http.*
import shohjahon.example.akfa_app.network.response.loginResponse.LogiResponse

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("users/login")
    suspend fun login(
        @Body data: String,
    ): LogiResponse



}