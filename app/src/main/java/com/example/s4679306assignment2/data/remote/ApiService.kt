package com.example.s4679306assignment2.data.remote

import retrofit2.http.*

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val keypass: String
)

data class DashboardEntity(
    val property1: String? = null,
    val property2: String? = null,
    val description: String? = null
)

data class DashboardResponse(
    val entities: List<DashboardEntity> = emptyList(),
    val entityTotal: Int = 0
)

interface ApiService {

    @POST("footscray/auth")
    suspend fun authFootscray(@Body body: LoginRequest): LoginResponse

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): DashboardResponse
}
