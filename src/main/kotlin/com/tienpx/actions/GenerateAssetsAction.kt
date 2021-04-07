package com.tienpx.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.tienpx.generation.AssetsFileGenerator

class GenerateAssetsAction: AnAction() {
    private var assetsFileGenerator: AssetsFileGenerator? = null

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(PlatformDataKeys.PROJECT)
        project?.let {
            assetsFileGenerator = AssetsFileGenerator(it)
            assetsFileGenerator?.generate()
        }
    }
}