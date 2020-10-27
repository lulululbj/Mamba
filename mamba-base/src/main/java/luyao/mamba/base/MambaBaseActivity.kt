package luyao.mamba.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import luyao.mamba.util.setStatusBarColor

/**
 * @author: luyao
 * @date：  2020/10/27 15:43
 */
abstract class MambaBaseActivity(@LayoutRes resId: Int) : AppCompatActivity(resId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(ContextCompat.getColor(this,R.color.mamba_main))
        initView()
    }

    abstract fun initView()
}