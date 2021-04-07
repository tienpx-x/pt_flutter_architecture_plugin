package com.tienpx.extension

val String.isSvgExtension: Boolean
    get() = endsWith(".svg", true)

val String.isImageExtension: Boolean
    get() = endsWith(".png", true)
            || endsWith(".jpg", true)
            || endsWith(".webp", true)