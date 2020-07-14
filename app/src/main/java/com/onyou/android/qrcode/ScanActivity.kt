package com.onyou.android.qrcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import kotlinx.android.synthetic.main.activity_scan.*

class ScanActivity : AppCompatActivity(), DecoratedBarcodeView.TorchListener {
    private var manager : CaptureManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        manager = CaptureManager(this, barcodeView)
        manager!!.initializeFromIntent(intent, savedInstanceState)
        manager!!.decode()
    }

    override fun onTorchOn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTorchOff() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        manager?.onResume()
    }

    override fun onPause() {
        super.onPause()
        manager?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        manager?.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        manager?.onSaveInstanceState(outState)
    }
}
