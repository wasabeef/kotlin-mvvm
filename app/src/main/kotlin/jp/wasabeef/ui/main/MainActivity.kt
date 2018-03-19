package jp.wasabeef.ui.main

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import jp.wasabeef.R
import jp.wasabeef.databinding.ActivityMainBinding
import jp.wasabeef.ui.component.activity.BaseActivity
import jp.wasabeef.ui.main.home.HomeFragment
import jp.wasabeef.ui.main.info.InfoFragment
import jp.wasabeef.ui.main.mypage.MyPageFragment
import jp.wasabeef.util.Display
import jp.wasabeef.util.ext.replaceFragment
import jp.wasabeef.util.ext.setFragment

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

//    @Inject
//    lateinit var mainViewModel: MainViewModel

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragment(R.id.frame_main_content, ::HomeFragment)
        binding.bottomNavMain.setOnNavigationItemSelectedListener(this)

        Display.showSystemUi(window)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            binding.bottomNavMain.selectedItemId -> return false
            R.id.action_home -> replaceFragment(R.id.frame_main_content, ::HomeFragment)
            R.id.action_info -> replaceFragment(R.id.frame_main_content, ::InfoFragment)
            R.id.action_my_page -> replaceFragment(R.id.frame_main_content, ::MyPageFragment)
            else -> throw IllegalStateException("Not founded this ID")
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
