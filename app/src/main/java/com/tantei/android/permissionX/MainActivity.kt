package com.tantei.android.permissionX

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.tantei.android.permissionx.PermissionX

class MainActivity : AppCompatActivity() {

    private lateinit var btnPhoneCall: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPhoneCall = findViewById(R.id.btn_phone_call)

        btnPhoneCall.setOnClickListener {
            PermissionX.request(this, Manifest.permission.CALL_PHONE) {allGranted, deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10010")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}