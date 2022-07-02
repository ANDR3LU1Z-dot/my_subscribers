package com.example.my_subscribers.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.my_subscribers.data.db.entity.SubscriberEntity

/*
Os objetos de acesso a dados (DAOs, na sigla em inglês), que fornecem métodos que o app pode usar
para consultar, atualizar, inserir e excluir dados do banco de dados.
 */

@Dao
interface SubscriberDAO {
    @Insert //Essas anotações já irão gerar no tempo de compilação do código um código SQLITE
    suspend fun insert(subscriber: SubscriberEntity): Long

    @Update
    suspend fun update(subscriber: SubscriberEntity)

    @Query("DELETE FROM subscriber WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM subscriber")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber")
    fun getAll(): LiveData<List<SubscriberEntity>>

}