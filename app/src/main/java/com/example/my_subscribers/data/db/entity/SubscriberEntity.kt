package com.example.my_subscribers.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//As entidades de dados, que representam tabelas no banco de dados do app.

@Entity(tableName = "subscriber")
data class SubscriberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String
)