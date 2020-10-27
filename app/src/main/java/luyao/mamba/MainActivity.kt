package luyao.mamba

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import luyao.mamba.base.MambaBaseActivity
import luyao.mamba.fps.FpsViewActivity

class MainActivity : MambaBaseActivity(R.layout.activity_main) {

    override fun initView() {
        fpsBt.setOnClickListener { startActivity(Intent(this,FpsViewActivity::class.java)) }
    }
}