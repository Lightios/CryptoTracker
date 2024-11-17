package com.plcoding.cryptotracker.core.presentation.util

import android.content.Context
import com.plcoding.cryptotracker.R
import com.plcoding.cryptotracker.core.domain.util.NetworkError

fun NetworkError.toString(context: Context): String {
    val resId = when(this) {
        NetworkError.NO_INTERNET -> R.string.error_request_timeout
        NetworkError.SERIALIZATION -> R.string.error_request_timeout
        NetworkError.UNKNOWN -> R.string.error_request_timeout
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUESTS -> R.string.too_many_requests
        NetworkError.SERVER_ERROR -> R.string.error_request_timeout
    }

    return context.getString(resId)
}