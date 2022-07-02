package com.example.my_subscribers.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.my_subscribers.data.db.dao.SubscriberDAO
import com.example.my_subscribers.data.db.entity.SubscriberEntity
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

/*
A classe de banco de dados, que contém o banco de dados e serve como o ponto de acesso principal
para a conexão com os dados persistidos do app.
 */

@Database(entities = [SubscriberEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract val subscriberDAO: SubscriberDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance: AppDataBase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "app_database"
                    ).build()
                }
                return instance
            }
        }
    }
}