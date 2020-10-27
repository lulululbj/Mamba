package luyao.mamba.fps

import kotlinx.android.synthetic.main.activity_fps.*
import luyao.mamba.base.MambaBaseActivity

/**
 * @author: luyao
 * @date：  2020/10/27 14:39
 */
class FpsViewActivity : MambaBaseActivity(R.layout.activity_fps) {

    override fun initView() {
        fpsStart.setOnClickListener { FpsMonitor.startMonitor() }
        fpsStop.setOnClickListener { FpsMonitor.stopMonitor() }
    }

}