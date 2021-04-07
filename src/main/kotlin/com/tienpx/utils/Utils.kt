package com.tienpx.utils

import com.intellij.ide.impl.ProjectUtil
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.WindowManager
import com.intellij.psi.PsiElement




object Utils {
    fun showNotify(message: String?) {
        val notificationGroup = NotificationGroup("PT Flutter Architecture", NotificationDisplayType.BALLOON, true)
        ApplicationManager.getApplication().invokeLater {
            val notification = notificationGroup.createNotification(message!!, NotificationType.INFORMATION)
            Notifications.Bus.notify(notification)
        }
    }

    fun showError(message: String?) {
        val notificationGroup = NotificationGroup("PT Flutter Architecture", NotificationDisplayType.BALLOON, true)
        ApplicationManager.getApplication().invokeLater {
            val notification = notificationGroup.createNotification(message!!, NotificationType.ERROR)
            Notifications.Bus.notify(notification)
        }
    }

    fun openFile(file: VirtualFile) {
        val projects = ProjectUtil.getOpenProjects()
        for (project in projects) {
            val window = WindowManager.getInstance().suggestParentWindow(project)
            if (window != null && window.isActive) {
                project?.let { OpenFileDescriptor(it, file).navigate(true) }
                return
            }
        }
    }

    fun PsiElement.openFile(vFile: VirtualFile) {
        FileEditorManager.getInstance(project)
            .openTextEditor(OpenFileDescriptor(project, vFile), true)
    }

    fun String.toLowCamelCase(): String {
        return if (this.isEmpty()) {
            this
        } else {
            val split = this.split("_")
            val sb = StringBuilder()
            for (i in split.indices) {
                if (i == 0) {
                    sb.append(split[i])
                } else {
                    sb.append(split[i].toUpperCaseFirst())
                }
            }
            return sb.toString()
        }
    }

    fun String.toUpperCaseFirst(): String {
        return if (this.isEmpty()) {
            this
        } else {
            "${this[0].toUpperCase()}${this.subSequence(1, this.length)}"
        }
    }
}
