package org.jellyfin.mobile.utils

import android.net.Uri

/**
 * A minimal, server-independent URI contract for opening library item details.
 * HTTPS App Links require a separate domain-verification design.
 */
object ItemDeepLink {
    fun parse(uri: Uri?): String? {
        if (uri?.scheme != "jellyfin" || uri.host != "item") return null
        if (uri.pathSegments.size != 1) return null
        val id = uri.pathSegments.single()
        return id.takeIf { it.matches(Regex("[0-9a-fA-F]{32}")) }
    }
}
