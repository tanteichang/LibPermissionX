package com.tantei.android.permissionx

import androidx.fragment.app.FragmentActivity

object PermissionX {
    private const val TAG = "com.tantei.android.PermissionX.InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permissions: String, callback: PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment == null) {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        } else {
            existedFragment as InvisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}