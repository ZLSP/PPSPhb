package com.zlsp.android.ppsphb.present

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.databinding.ActivityMainBinding
import com.zlsp.android.ppsphb.domain.menu.MenuItem
import com.zlsp.android.ppsphb.present.fragments.osnov.OsnovFragment
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

        binding.iToolbar.btnMenu.setOnClickListener {
            println("click")
            binding.iMenu.clDrawerMenu.visibility = VISIBLE
        }
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
            when(it.id) {
                0 -> {
                    launchFragment(ZakonFragment.newInstance())
                }
                2 -> {
                    launchFragment(OsnovFragment.newInstance())
                }
            }
        }
    }

    private fun launchFragment(fragment: Fragment) {
        binding.iMenu.clDrawerMenu.visibility = GONE
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Закрыть приложение")
            setPositiveButton("Да") { _, i ->
                finishAffinity()
            }
            setNegativeButton("Нет") {_, i ->
            }
        }.show()
    }

    override fun onBackPressed() {
        if (binding.iMenu.clDrawerMenu.visibility == GONE)
            showAlertDialog()
        else
            binding.iMenu.clDrawerMenu.visibility = GONE
    }
}