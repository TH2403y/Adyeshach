package ink.ptms.adyeshach.common.util

import com.google.common.base.Enums

fun <T : Enum<T>> Class<T>.getEnum(vararg name: Any): T {
    name.forEach { Enums.getIfPresent(this, it.toString()).orNull()?.let { e -> return e } }
    errorBy("error-unable-to-find-enum", simpleName, name.joinToString(" "))
}

fun <T : Enum<T>> Class<T>.getEnumOrNull(vararg name: Any): T? {
    name.forEach { Enums.getIfPresent(this, it.toString()).orNull()?.let { e -> return e } }
    return null
}