package com.example.xenoblade3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xenoblade3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Thread.sleep(1500)
        installSplashScreen()
        setContentView(binding.root)
        title = "Xenoblade 3"

        binding.rvChara.setHasFixedSize(true)

        list.addAll(getListChara())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListChara(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataGender = resources.getStringArray(R.array.data_gender)
        val dataFaction = resources.getStringArray(R.array.data_faction)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataVaEn = resources.getStringArray(R.array.va_en)
        val dataVaJp = resources.getStringArray(R.array.va_jp)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listChara = ArrayList<Character>()
        for (i in dataName.indices) {
            val chara = Character(dataName[i], dataDescription[i], dataGender[i], dataFaction[i], dataRole[i], dataVaEn[i], dataVaJp[i], dataPhoto.getResourceId(i, -1))
            listChara.add(chara)
        }
        return listChara
    }

    private fun showRecyclerList() {
        binding.rvChara.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCharaAdapter(list)
        binding.rvChara.adapter = listHeroAdapter
    }
}