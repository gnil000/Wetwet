package com.yfrite.wetwet.adapters

import android.content.ContentResolver
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.yfrite.wetwet.R
import com.yfrite.wetwet.models.AnswerModel


class AnswerAdapter(private val dataSet: List<AnswerModel>) :
    RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ShapeableImageView
        val sender: TextView
        val name: TextView
        val text: TextView
        val publishDate: TextView

        init {
            name = view.findViewById(R.id.name)
            photo = view.findViewById(R.id.photo)
            sender = view.findViewById(R.id.sender)
            text = view.findViewById(R.id.text)
            publishDate = view.findViewById(R.id.publish_date)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.answer_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val reply = dataSet[position]

        viewHolder.name.text = reply.name
        viewHolder.sender.text = reply.sender
        viewHolder.text.text = reply.text
        viewHolder.publishDate.text = reply.replyDate

        val photoUri = reply.photo
        val contentResolver: ContentResolver = viewHolder.name.context.contentResolver
        val bitmap = if (Build.VERSION.SDK_INT < 28) {
            MediaStore.Images.Media.getBitmap(contentResolver, photoUri)
        } else {
            val source = ImageDecoder.createSource(contentResolver, photoUri)
            ImageDecoder.decodeBitmap(source)
        }

        viewHolder.photo.setImageBitmap(bitmap)
    }

    override fun getItemCount() = dataSet.size

}
