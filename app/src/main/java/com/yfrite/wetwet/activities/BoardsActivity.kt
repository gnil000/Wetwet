package com.yfrite.wetwet.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.yfrite.wetwet.R
import com.yfrite.wetwet.adapters.BoardAdapter
import com.yfrite.wetwet.models.NameDescriptionModel

class BoardsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boards)

        val boardsList: RecyclerView = findViewById(R.id.boards_list)
        val home: Button = findViewById(R.id.home)

        val boards = arrayOf(
            NameDescriptionModel("Млекопитающие", "Класс позвоночных животных, основной отличительной особенностью которых является вскармлиывание детёнышей молоком. Класс входит в кладу синапсид надкласса четвероногих."),
            NameDescriptionModel("Рыбы", "Обширная группа водных челюстноротых позвоночных животных, ранее считавшаяся надклассом. Рыбы характеризуются жаберным дыханием на всех этапах постэмбрионального развития организма. С точки зрения кладистики четвероногие являются специализированными лопастепёрыми рыбами."),
            NameDescriptionModel("Земноводные", "Класс четвероногих позвоночных животных, включающий в себя тритонов, саламандр, лягушек и червяг и насчитывающий около 8500 современных видов. Земноводные обитают практически повсеместно."),
            NameDescriptionModel("Пресмыкающиеся", "Традиционно выделяемый класс преимущественно наземных позвоночных животных из клады амниот, включающий современных черепах, крокодилов, клювоголовых и чешуйчатых. Пресмыкающиеся являются парафилетической группой, так как дали начало птицам, но не включают их самих"),
            NameDescriptionModel("Птицы", "Группа теплокровных яйцекладущих позвоночных животных, традиционно рассматриваемая в ранге отдельного класса. Хорошо обособлена от остальных групп современных животных."))

        boardsList.adapter = BoardAdapter(boards)

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}