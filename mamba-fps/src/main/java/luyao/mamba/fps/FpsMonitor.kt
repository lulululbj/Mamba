package luyao.mamba.fps

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Choreographer

/**
 * @author: luyao
 * @date：  2020/10/27 16:24
 */
object FpsMonitor {

    const val FPS_INTERVAL_TIME = 1000L
    private var count = 0;
    private val fpsRunnable by lazy { FpsRunnable() }
    private val mainHandler by lazy { Handler(Looper.getMainLooper()) }

    fun startMonitor() {
        mainHandler.postDelayed(fpsRunnable, FPS_INTERVAL_TIME)
        Choreographer.getInstance().postFrameCallback(fpsRunnable)
    }

    fun stopMonitor(){
        mainHandler.removeCallbacks(fpsRunnable)
        Choreographer.getInstance().removeFrameCallback(fpsRunnable)
    }

    class FpsRunnable : Choreographer.FrameCallback, Runnable {
        override fun doFrame(frameTimeNanos: Long) {
            count++
            Choreographer.getInstance().postFrameCallback(this)
        }

        override fun run() {
            Log.e("fps", "fps is $count")
            count = 0
            mainHandler.postDelayed(this, FPS_INTERVAL_TIME)
        }
    }
}