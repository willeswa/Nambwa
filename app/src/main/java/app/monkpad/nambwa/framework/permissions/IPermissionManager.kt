package app.monkpad.nambwa.framework.permissions

import android.content.pm.PermissionInfo

interface IPermissionManager {
    fun hasPermissions(permission: Permissions): Boolean
    fun requestPermissions(permission: Permissions)
}