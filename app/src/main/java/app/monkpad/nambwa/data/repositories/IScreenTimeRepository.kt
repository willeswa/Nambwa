package app.monkpad.nambwa.data.repositories

import app.monkpad.nambwa.framework.permissions.Permissions

interface IScreenTimeRepository {
    fun hasPermissions(permissions: Permissions):Boolean
}