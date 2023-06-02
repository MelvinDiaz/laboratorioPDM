package com.example.laboratorio05.data.model

import androidx.room.Entity

@Entity(tableName = "actor_table", primaryKeys = ["actorId"])
data class ActorModel(
    var actorId: Long = 0L,
    val name: String,
)

