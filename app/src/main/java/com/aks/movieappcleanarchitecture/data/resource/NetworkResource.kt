package com.aks.movieappcleanarchitecture.data.resource

sealed class NetworkResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResource<T>(data)
    class Error<T>(message: String, data: T?=null) : NetworkResource<T>(data, "Failed to connect")
    class Loading<T>(data: T? = null) : NetworkResource<T>(data)

}