package com.lumos

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class LumosLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(
        project: Project,
        file: VirtualFile,
        serverStarter: LspServerSupportProvider.LspServerStarter
    ) {
        if (file.extension == LumosFileType.EXTENSION) {
            serverStarter.ensureServerStarted(LumosLspServerDescriptor(project))
        }
    }
}

class LumosLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "LUMOS") {
    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.extension == LumosFileType.EXTENSION
    }

    override fun createCommandLine(): GeneralCommandLine {
        // Try to find lumos-lsp in PATH
        val lumosLspPath = findLumosLspExecutable()
        return GeneralCommandLine(lumosLspPath)
    }

    private fun findLumosLspExecutable(): String {
        // First, try to find lumos-lsp in standard Cargo bin directory
        val cargoHome = System.getenv("CARGO_HOME") ?: "${System.getProperty("user.home")}/.cargo"
        val cargoBinLumosLsp = "$cargoHome/bin/lumos-lsp"

        if (java.io.File(cargoBinLumosLsp).exists()) {
            return cargoBinLumosLsp
        }

        // Fallback to searching PATH
        return "lumos-lsp"
    }
}
