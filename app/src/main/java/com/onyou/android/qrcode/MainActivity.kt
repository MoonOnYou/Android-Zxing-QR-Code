package com.onyou.android.qrcode

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewGoToScan.setOnClickListener {
            IntentIntegrator(this).setOrientationLocked(false)
                .setCaptureActivity(ScanActivity::class.java).initiateScan()
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        val toast : String?
        if (result != null) {
            toast = if (result.contents == null) {
                "Cancelled from null"
            } else {
                "Scanned from : " + result.contents
            }
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show()
        }
    }
}
