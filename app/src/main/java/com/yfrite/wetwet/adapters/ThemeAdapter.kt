package com.yfrite.wetwet.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yfrite.wetwet.R
import com.yfrite.wetwet.activities.QaActivity
import com.yfrite.wetwet.activities.ThemesActivity
import com.yfrite.wetwet.models.NameDescriptionModel

class ThemeAdapter(private val dataSet: List<NameDescriptionModel>) :
    RecyclerView.Adapter<ThemeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val description: TextView
        val select: Button

        init {
            name = view.findViewById(R.id.name)
            description = view.findViewById(R.id.description)
            select = view.findViewById(R.id.select)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.name_description_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val theme = dataSet[position]

        viewHolder.name.text = theme.name
        viewHolder.description.text = theme.description

        viewHolder.select.text = "Перейти"
        val context: Activity = viewHolder.name.context as Activity

        viewHolder.select.setOnClickListener {
            val intent = Intent(context, QaActivity::class.java)
            intent.putExtra("name", theme.name)
            viewHolder.name.context.startActivity(intent)
            context.finish()
        }
    }

    override fun getItemCount() = dataSet.size

}
