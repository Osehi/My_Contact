package com.polish.mycontact.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.polish.mycontact.database.ContactRepository
import com.polish.mycontact.model.Contact

class ContactViewModel(application: Application):AndroidViewModel(application) {

    private var repository = ContactRepository(application)
    private var allContact = repository.getAllContact()


    fun insertContact(contact: Contact){
        repository.insertContact(contact, getApplication())
    }


    fun delete(contact:Contact){
        repository.delete(contact, getApplication())
    }

    fun update(contact:Contact){
        repository.update(contact, getApplication())
    }

    fun getAllContact():LiveData<List<Contact>>{
        return allContact
    }

}