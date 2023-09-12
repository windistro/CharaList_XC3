package com.example.xenoblade3

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CHARA = "key_character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tvName)
        val tvDesc: TextView = findViewById(R.id.tvDesc)
        val tvGender: TextView = findViewById(R.id.chara_gender)
        val tvFaction: TextView = findViewById(R.id.chara_faction)
        val tvRole: TextView = findViewById(R.id.chara_role)
        val tvEn: TextView = findViewById(R.id.chara_va_en)
        val tvJp: TextView = findViewById(R.id.chara_va_jp)
        val imgChara: ImageView = findViewById(R.id.img_chara)

        val dataCharacter = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Character>(EXTRA_CHARA, Character::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Character>(EXTRA_CHARA)
        }

        if (dataCharacter != null) {
            title = dataCharacter.name
            tvName.text = dataCharacter.name
            tvDesc.text = dataCharacter.description
            tvGender.text = dataCharacter.gender
            tvFaction.text = dataCharacter.faction
            tvRole.text = dataCharacter.role
            tvEn.text = dataCharacter.vaEn
            tvJp.text = dataCharacter.vaJp
            imgChara.setImageResource(dataCharacter.photo)
        }
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                val body = "Share!!!!!!!!!!!"
                shareIntent.putExtra(Intent.EXTRA_TEXT, body)
                startActivity(Intent.createChooser(shareIntent, "Share using"))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    }