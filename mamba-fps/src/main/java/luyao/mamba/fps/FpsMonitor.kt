package luyao.mamba.fps

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Choreographer

/**
 * Monitor fps
 * @author: luyao
 * @date：  2020/10/27 16:24
 */
object FpsMonitor {

    private const val FPS_INTERVAL_TIME = 1000L
    private var count = 0
    private var isFpsOpen = false
    private val fpsRunnable by lazy { FpsRunnable() }
    private val mainHandler by lazy { Handler(Looper.getMainLooper()) }
    private val listeners = arrayListOf<(Int) -> Unit>()

    fun startMonitor(listener: (Int) -> Unit) {
        // 防止重复开启
        if (!isFpsOpen) {
            isFpsOpen = true
            listeners.add(listener)
            mainHandler.postDelayed(fpsRunnable, FPS_INTERVAL_TIME)
            Choreographer.getInstance().postFrameCallback(fpsRunnable)
        }
    }

    fun stopMonitor() {
        count = 0
        mainHandler.removeCallbacks(fpsRunnable)
        Choreographer.getInstance().removeFrameCallback(fpsRunnable)
        isFpsOpen = false
    }

    class FpsRunnable : Choreographer.FrameCallback, Runnable {
        override fun doFrame(frameTimeNanos: Long) {
            count++
            Choreographer.getInstance().postFrameCallback(this)
        }

        override fun run() {
            //TODO 仅当应用处于前台时输出 fps
            Log.e("fps", "fps is $count")
            listeners.forEach { it.invoke(count) }
            count = 0
            mainHandler.postDelayed(this, FPS_INTERVAL_TIME)
        }
    }
}