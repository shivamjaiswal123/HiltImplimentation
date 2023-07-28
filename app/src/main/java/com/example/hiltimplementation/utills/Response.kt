package com.example.hiltimplementation.utills

import com.example.hiltimplementation.data.model.Post

//sealed class Response(){
//    class Loading(): Response()
//    class Success(val data: Post): Response()
//    class Error(val errorMsg: String): Response()
//}


sealed class Response<T>(val data: T? = null, val errorMsg: String? = null){
    class Loading<T>: Response<T>()
    class Success<T>(data: T): Response<T>(data = data)
    class Error<T>(errorMsg: String): Response<T>(errorMsg = errorMsg)
}
