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
import com.yfrite.wetwet.activities.DescriptionActivity
import com.yfrite.wetwet.activities.ThemesActivity
import com.yfrite.wetwet.models.NameDescriptionModel

class BoardAdapter(private val dataSet: Array<NameDescriptionModel>) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val description: TextView
        val select_board: Button

        init {
            name = view.findViewById(R.id.name)
            description = view.findViewById(R.id.description)
            select_board = view.findViewById(R.id.select)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.name_description_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val board = dataSet[position]

        viewHolder.name.text = board.name
        viewHolder.description.text = board.description

        val context: Activity = viewHolder.name.context as Activity
        viewHolder.select_board.setOnClickListener {
            val intent = Intent(context, ThemesActivity::class.java)
            intent.putExtra("name", board.name)
            viewHolder.name.context.startActivity(intent)
            context.finish()
        }

        viewHolder.description.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("name", board.name)
            viewHolder.name.context.startActivity(intent)
            context.finish()
        }

        viewHolder.name.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("name", board.name)
            viewHolder.name.context.startActivity(intent)
            context.finish()
        }
    }

    override fun getItemCount() = dataSet.size

}
