package com.yfrite.wetwet.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yfrite.wetwet.R
import com.yfrite.wetwet.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val name = intent.extras!!.getString("name")

        val descriptions = mapOf("Млекопитающие" to "Млекопита́ющие (лат. Mammalia) — класс позвоночных животных, основной отличительной особенностью которых является вскармливание детёнышей молоком. Класс входит в кладу синапсид надкласса четвероногих и представляет собой самую прогрессивную группу позвоночных. По подсчётам биологов, известно более 6500 современных видов млекопитающих, среди которых и вид Человек разумный (лат. Homo sapiens); общее же число видов млекопитающих, включая вымершие, превышает 20 000. Млекопитающие распространены почти повсеместно. Произошли от высокоразвитых синапсид в конце триаса. К млекопитающим относят ныне живущих однопроходных, сумчатых и плацентарных, а также большое число вымерших групп. Современные виды, входящие в класс млекопитающих, объединяют в 26—29 отрядов. Внешний вид млекопитающих весьма разнообразен, но в целом соответствует характерному и для других четвероногих плану строения. Анатомия и физиология млекопитающих характеризуется наличием тех же функциональных систем, что и у прочих четвероногих. Однако многие из этих систем достигли высокого уровня развития, так что данный класс среди позвоночных считают наиболее высокоорганизованным. Приспособления млекопитающих к жизни в различных средах обитания весьма разнообразны, их поведение отличается сложностью и многообразием. Они занимают доминирующие позиции среди наземной фауны (в водной среде они уступают лишь лучепёрым рыбам). Млекопитающие играют большую роль в жизни и хозяйственной деятельности человека: они выступают как важные источники продуктов питания и производственного сырья, выполняют транспортные функции, служат тягловой силой, используются как лабораторные животные и домашние питомцы. Изучением млекопитающих занимается наука териология (маммалиология). Млекопитающие распространены по всему миру и встречаются на всех континентах, во всех океанах и на большинстве существующих островов. Современный ареал однопроходных ограничивается Австралией, Тасманией и Новой Гвинеей, сумчатых — территорией Австралии, Океании и обоих американских континентов[8]. Самое широкое распространение — у плацентарных, которые уже с конца мезозоя стали доминирующими наземными позвоночными на всех континентах, кроме Австралии и Антарктиды[9], преобладая по численности особей, биомассе и положению в пищевых цепях[10]. В Австралии же до начала европейской колонизации обитали, не считая человека, лишь немногие виды плацентарных, а именно летучие мыши и мышиные. На отдалённых от других материков островах до прибытия человека существовала лишь бедная видами фауна млекопитающих: на многих из них, в том числе и в Новой Зеландии, её представляли только несколько видов летучих мышей[11].")

        binding.description.text = descriptions[name]!!
        binding.description.movementMethod = ScrollingMovementMethod()
        binding.boardName.text = name

        binding.selectBoard.setOnClickListener {
            val themeIntent = Intent(this, ThemesActivity::class.java)
            themeIntent.putExtra("name", name)
            startActivity(themeIntent)
            finish()
        }

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