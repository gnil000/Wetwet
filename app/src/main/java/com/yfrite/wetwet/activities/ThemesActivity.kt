package com.yfrite.wetwet.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.yfrite.wetwet.R
import com.yfrite.wetwet.adapters.ThemeAdapter
import com.yfrite.wetwet.models.NameDescriptionModel

class ThemesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_themes)

        val themes = mapOf("Млекопитающие" to listOf(NameDescriptionModel("Кошки", "Домашнее животное, одно из наиболее популярных «животных-компаньонов». С точки зрения научной систематики, домашняя кошка — млекопитающее семейства кошачьих отряда хищных. Одни исследователи рассматривают домашнюю кошку как подвид дикой кошки, другие — как отдельный биологический вид."),
            NameDescriptionModel("Собаки", "Домашнее животное, одно из наиболее популярных животных-компаньонов. Домашняя собака была описана как самостоятельный биологический вид Canis familiaris Линнеем в 1758 году; в настоящее время данное научное название признаётся организациями, такими как Американское общество маммалогов."),
            NameDescriptionModel("Зайцы", "Род из семейства зайцевых. Распространены везде, кроме Австралии и Антарктиды, всего около 30 видов. Отличаются длинными ушами, коротким поднятым хвостом, недоразвитыми ключицами, длинными задними лапами, что позволяет им двигаться прыжками. Русак может достигать скорости 70 км/ч."),
            NameDescriptionModel("Мыши", "Семейство млекопитающих из отряда грызунов. Длина тела от 5 см до 48 см. В фауне России примерно 13 видов мышиных."),
            NameDescriptionModel("Лошади", "Животное из семейства лошадиных отряда непарнокопытных, одомашненный потомок дикой лошади. Используется человеком вплоть до настоящего времени. Наука о лошадях — иппология.")))

        val intent = intent
        val name = intent.extras?.getString("name")

        val themesText: TextView = findViewById(R.id.themes_text)
        themesText.text = name

        val rv: RecyclerView = findViewById(R.id.themes_list)
        if (name in themes.keys)
            rv.adapter = ThemeAdapter(themes[name]!!)

        val boards: Button = findViewById(R.id.boards)
        val home: Button = findViewById(R.id.home)

        boards.setOnClickListener {
            val boardsIntent = Intent(this, BoardsActivity::class.java)
            startActivity(boardsIntent)
            finish()
        }
        home.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }
    }
}