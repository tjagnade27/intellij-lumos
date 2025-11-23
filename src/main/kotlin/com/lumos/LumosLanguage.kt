package com.lumos

import com.intellij.lang.Language

object LumosLanguage : Language("LUMOS") {
    override fun getDisplayName() = "LUMOS"
    override fun isCaseSensitive() = true
}
