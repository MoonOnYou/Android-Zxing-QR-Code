package com.onyou.android.qrcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import kotlinx.android.synthetic.main.activity_scan.*
import java.lang.reflect.Field

class ScanActivity : AppCompatActivity(), DecoratedBarcodeView.TorchListener {
    private var manager : CaptureManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        disableLaser()
        manager = CaptureManager(this, barcodeView)
        manager!!.initializeFromIntent(intent, savedInstanceState)
        manager!!.decode()
    }

    private fun disableLaser() {
        val viewFinder = barcodeView.viewFinder
        val scannerAlphaField: Field?

        try {
            scannerAlphaField = viewFinder.javaClass.getDeclaredField("SCANNER_ALPHA")
            scannerAlphaField.isAccessible = true
            scannerAlphaField.set(viewFinder, IntArray(1))

        } catch (e: NoSuchFieldException) {
            e.printStackTrace()

        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

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
