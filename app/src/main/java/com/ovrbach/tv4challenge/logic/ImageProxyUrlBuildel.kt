package com.ovrbach.tv4challenge.logic

import android.net.Uri
import javax.inject.Inject

class ImageProxyUrlBuilder @Inject constructor() {

    fun homeImage(originalUrl: String) = Uri.Builder()
        .scheme("https")
        .authority("imageproxy.b17g.services")
        .appendQueryParameter("source", originalUrl)
        .appendQueryParameter("shape", "cut")
        .appendQueryParameter("retina", "true")
        .appendQueryParameter("resize", "250x250")
        .build()
        .toString()
}