package com.zlsp.android.ppsphb.present

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.databinding.ActivityMainBinding
import com.zlsp.android.ppsphb.domain.menu.MenuItem
import com.zlsp.android.ppsphb.present.fragments.zakon.ZakonFragment
import com.zlsp.android.ppsphb.present.menu.MenuListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var menuListAdapter: MenuListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupMenuListRV()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        createMenuList()
        viewModel.menuList.observe(this) {
            menuListAdapter.submitList(it)
        }
        launchFragment(ZakonFragment.newInstance())
    }

    private fun createMenuList() {
        val list = mutableListOf<MenuItem>()
        val arrayIcons = listOf(
            R.drawable.svg_zakon,
            R.drawable.svg_raports,
            R.drawable.svg_osnov,
            R.drawable.svg_polnomoch,
            R.drawable.svg_tth,
            R.drawable.svg_redaction
        )
        val arrayFragments = listOf(
            ZakonFragment.newInstance()
        )
        val arrayNames = resources.getStringArray(R.array.array_menu_names)
        arrayNames.forEachIndexed { index, name ->
            list.add(MenuItem(index, arrayIcons[index], name))
        }
        viewModel.setMenuList(list)
    }

    private fun setupMenuListRV() {
        menuListAdapter = MenuListAdapter()
        binding.iMenu.rvMenuList.adapter = menuListAdapter
        menuListAdapter.onMenuItemClickListener = {

        }
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}