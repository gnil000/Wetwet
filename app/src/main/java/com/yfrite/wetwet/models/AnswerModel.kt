package com.yfrite.wetwet.models

import android.net.Uri

data class AnswerModel(
    val photo: Uri,
    val sender: String,
    val name: String?,
    val text: String,
    val replyDate: String,
    val isAuthor: Boolean,

//    val replies: List<AnswerModel>
)
