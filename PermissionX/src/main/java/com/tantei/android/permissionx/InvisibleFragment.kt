package com.tantei.android.permissionx

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

typealias PermissionCallback = (Boolean, List<String>) -> Unit

class InvisibleFragment : Fragment() {

    companion object {
        private const val REQUEST_CODE = 1
    }

    private var callback: PermissionCallback? = null

    fun requestNow(cb: PermissionCallback, vararg permissions: String) {
        callback = cb
        requestPermissions(permissions, REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE) {
            val deniedList = ArrayList<String>()
            for ((index, result) in grantResults.withIndex()) {
                if (result == PackageManager.PERMISSION_DENIED) {
                    deniedList.add(permissions[index])
                }
            }
            val allGranted = deniedList.isEmpty();
            callback?.let { it(allGranted, deniedList) }
        }
    }
}