package luyao.mamba.util

import android.app.Activity
import android.view.WindowManager
import androidx.annotation.ColorInt

/**
 * @author: luyao
 * @date：  2020/10/27 14:43
 */
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.run {
        statusBarColor = color
    }
}