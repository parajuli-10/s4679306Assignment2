package com.example.s4679306assignment2.data

import com.example.s4679306assignment2.data.remote.ApiService
import com.example.s4679306assignment2.data.remote.DashboardResponse
import com.example.s4679306assignment2.data.remote.LoginRequest
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

open class Repository @Inject constructor(
    private val api: ApiService
) {
    open suspend fun login(username: String, password: String): String {

        val res = api.authFootscray(LoginRequest(username.lowercase(), password))
        return res.keypass
    }

    open suspend fun dashboard(keypass: String): DashboardResponse =
        api.getDashboard(keypass)
}
