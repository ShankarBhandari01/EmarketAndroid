package com.example.emarketapplication.repository

import com.example.emarketapplication.api.ClientsApi
import com.example.emarketapplication.api.MyApiRequest
import com.example.emarketapplication.api.ServiceBuilder
import com.example.emarketapplication.modal.Users
import com.example.emarketapplication.response.UserSignupResponse
import com.example.emarketapplication.response.UsersLoginResponse

class UserRepository : MyApiRequest() {
    val myClientsApi = ServiceBuilder.buildService(ClientsApi::class.java)


    suspend fun login(username: String, password: String): UsersLoginResponse {
        return apiRequest {
            myClientsApi.login(username, password)
        }
    }

    suspend fun signup(User: Users): UserSignupResponse {
        return apiRequest {
            myClientsApi.Signup(User)
        }
    }

    suspend fun getRequest(): UsersLoginResponse {
        return apiRequest {
            myClientsApi.loadRequest(ServiceBuilder.token!!)
        }
    }

    suspend fun deleteRequest(id: String): UsersLoginResponse {
        return apiRequest {
            myClientsApi.deleteRequest(ServiceBuilder.token!!, id)
        }
    }
}