package luyao.mamba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import luyao.core.MambaManager


class MainActivity : AppCompatActivity(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MambaManager.init(this)
        initListener()
    }

    private fun initListener() {
        sleep.setOnClickListener { Thread.sleep(1000) }
        startFps.setOnClickListener { MambaManager.startMonitorFps() }
        stopFps.setOnClickListener { MambaManager.stopMonitorFps() }
    }

}