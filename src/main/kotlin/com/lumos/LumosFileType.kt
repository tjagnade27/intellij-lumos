package com.lumos

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object LumosFileType : LanguageFileType(LumosLanguage) {
    override fun getName() = "LUMOS"
    override fun getDescription() = "LUMOS schema language file"
    override fun getDefaultExtension() = "lumos"
    override fun getIcon(): Icon = LumosIcons.FILE

    const val EXTENSION = "lumos"
}
