package com.example.databindingmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.databindingmvvm.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userlogin(email: String, password: String): LiveData<String> {
        val loginresponse = MutableLiveData<String>()
        MyApi().userlogin(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        loginresponse.value=response.body()?.string()

                    }else{
                        loginresponse.value=response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginresponse.value=t.message
                    }

            })
        return loginresponse
    }
}