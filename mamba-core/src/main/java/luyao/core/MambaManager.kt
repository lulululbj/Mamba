package luyao.core

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.TextView
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.interfaces.OnInvokeView
import luyao.mamba.fps.FpsMonitor

/**
 * @author: luyao
 * @date：  2020/10/28 15:07
 */

object MambaManager {

    private lateinit var fpsView: TextView

    fun init(context: Activity) {
        EasyFloat.with(context)
            .setLayout(R.layout.float_mamba, OnInvokeView { view ->
                fpsView = view.findViewById(R.id.fpsValue)
            })
            .setShowPattern(ShowPattern.ALL_TIME)
            .registerCallback { }
            .show()
    }

    fun startMonitorFps() {
        FpsMonitor.startMonitor { fps ->
            fpsView.visibility = View.VISIBLE
            fpsView.text = String.format("fps: %s", fps)
        }
    }

    fun stopMonitorFps() {
        FpsMonitor.stopMonitor()
        fpsView.visibility = View.GONE
    }
}