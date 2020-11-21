package com.ovrbach.tv4challenge.data.remote

import android.content.res.Resources
import com.ovrbach.tv4challenge.R
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorHandler @Inject constructor(resources: Resources) {

    fun mapError(throwable: Throwable) =
            when (throwable) {
                is UnknownHostException -> noInternetConnection
                is SocketTimeoutException -> noInternetConnection //should be different
                else -> throwable
            }


    private val noInternetConnection = KnownError(resources.getString(R.string.error_no_internet))

    data class KnownError(
            override val message: String
    ) : IllegalStateException(message)

}