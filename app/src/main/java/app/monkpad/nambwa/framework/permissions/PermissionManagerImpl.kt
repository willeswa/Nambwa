package app.monkpad.nambwa.framework.permissions

import android.app.AppOpsManager
import android.content.Context
import android.os.Build


class PermissionManagerImpl(private val context: Context) : IPermissionManager {
    override fun hasPermissions(permission: Permissions): Boolean {
        return when (permission) {
            Permissions.USAGE_STATS -> checkPermissions(
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                context
            )
        }
    }

    override fun requestPermissions(permission: Permissions) {
        TODO("Not yet implemented")
    }

    companion object {
        fun launchPermissionsDialog(title: String, message: String) {

        }

        fun checkPermissions(ops: String, context: Context): Boolean {
            return try {
                val packageName = context.packageName
                val uuid = android.os.Process.myUid()
                val appOpsManager =
                    context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val mode = appOpsManager.unsafeCheckOpNoThrow(ops, uuid, packageName)
                    mode == AppOpsManager.MODE_ALLOWED
                } else {
                    val mode = appOpsManager.checkOpNoThrow(ops, uuid, packageName)
                    mode == AppOpsManager.MODE_ALLOWED
                }

            } catch (e: Exception) {
                false
            }
        }
    }
}