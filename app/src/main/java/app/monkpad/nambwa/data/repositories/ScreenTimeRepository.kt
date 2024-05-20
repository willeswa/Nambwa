package app.monkpad.nambwa.data.repositories

import app.monkpad.nambwa.framework.permissions.IPermissionManager
import app.monkpad.nambwa.framework.permissions.Permissions
import javax.inject.Inject

class ScreenTimeRepository @Inject constructor(private val iPermissions: IPermissionManager) {
    fun hasPermissions(permissions: Permissions): Boolean {
        return iPermissions.hasPermissions(permissions)
    }

}