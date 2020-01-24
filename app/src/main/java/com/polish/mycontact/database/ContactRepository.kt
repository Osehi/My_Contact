package com.polish.mycontact.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.polish.mycontact.model.Contact
import com.polish.mycontact.utils.CoroutineContactSingleton

class ContactRepository(application: Application) {

    private var contactDao:ContactDao

    private var allContacts:LiveData<List<Contact>>

    init {
        val database:ContactDatabase = ContactDatabase.getInstance(application.applicationContext)

        contactDao = database.contactDao()
        allContacts = contactDao.getAllContact()
    }

    fun insertContact(contact:Contact, application: Application){
        CoroutineContactSingleton.getInstance(application).insertContact(contactDao,contact)
    }

    fun delete(contact:Contact, application: Application){
        CoroutineContactSingleton.getInstance(application).delete(contactDao, contact)
    }

    fun update(contact:Contact, application: Application){
        CoroutineContactSingleton.getInstance(application).update(contactDao,contact)
    }

    fun getAllContact():LiveData<List<Contact>>{
        return allContacts
    }

}