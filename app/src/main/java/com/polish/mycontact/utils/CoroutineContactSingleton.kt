package com.polish.mycontact.utils

import android.app.Application
import com.polish.mycontact.database.ContactDao
import com.polish.mycontact.model.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineContactSingleton(application: Application) {

    companion object{
        @Volatile
        private var INSTANCE:CoroutineContactSingleton? = null

        fun getInstance(application: Application) =
            INSTANCE?:CoroutineContactSingleton(application).also {
                INSTANCE = it
            }
    }


    fun insertContact(contactDao:ContactDao ,contact: Contact){

        CoroutineScope(Dispatchers.IO).launch {
            contactDao.insertContact(contact)
        }

    }


    fun delete(contactDao:ContactDao,contact:Contact){

        CoroutineScope(Dispatchers.IO).launch {
            contactDao.delete(contact)
        }

    }


    fun update(contactDao:ContactDao, contact:Contact){

        CoroutineScope(Dispatchers.IO).launch {
            contactDao.update(contact)
        }

    }

    fun getAllContact(){

        CoroutineScope(Dispatchers.IO).launch {
            getAllContact()
        }

    }




}