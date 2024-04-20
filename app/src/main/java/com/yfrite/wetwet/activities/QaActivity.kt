package com.yfrite.wetwet.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.yfrite.wetwet.R
import com.yfrite.wetwet.adapters.AnswerAdapter
import com.yfrite.wetwet.databinding.ActivityQaBinding
import com.yfrite.wetwet.models.AnswerModel

class QaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_qa)

        val intent = intent

        val qaText: TextView = findViewById(R.id.qa_text)
        qaText.text = intent.extras!!.getString("name")

        val answers = listOf(AnswerModel(Uri.parse("android.resource://com.yfrite.wetwet/drawable/ava2"), "Вероника Малышкина", "Котёнок с улицы", "Здравствуйте, пару дней назад взяла котёнка с улицы. Был холодный голодный, забрала домой. Вы не подскажите какая порода, мне кажется он очень интересно выглядит, может есть порода у него какая? Фото прилагаю.",
            "24.04.2024 12:31", false),
            AnswerModel(Uri.parse("android.resource://com.yfrite.wetwet/drawable/ava"), "Дмитрий Уткин", null, "Котёнок очень милый. Скорее всего у него нет породы). Но это ни на что не влияет. Любите и заботьтесь о нём!", " 24.04.2024 13:01", true))

        val answersView: RecyclerView = findViewById(R.id.answers)
        answersView.adapter = AnswerAdapter(answers)

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