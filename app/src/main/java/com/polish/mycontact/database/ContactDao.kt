package com.polish.mycontact.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.polish.mycontact.model.Contact

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact:Contact)

    @Delete
    suspend fun delete(contact:Contact)

    @Update
    suspend fun update(contact:Contact)


    @Query("SELECT * FROM contact_table ORDER BY id DESC")
    fun getAllContact():LiveData<List<Contact>>

}