package com.polish.mycontact.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.polish.mycontact.R
import com.polish.mycontact.databinding.FragmentAddContactBinding
import com.polish.mycontact.model.Contact
import com.polish.mycontact.viewModel.ContactViewModel

/**
 * A simple [Fragment] subclass.
 */
class AddContact : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add_contact, container, false)

        val binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)



        binding.buttonSubmitId.setOnClickListener {
            var firstName = binding.editFirstNameId.text.toString()
            var lastName = binding.editLastNameId.text.toString()
            var email = binding.editEmailId.text.toString()
            var phone = binding.editPhoneId.text.toString()
            var address = binding.editAddressId.text.toString()

            val capturedContact = Contact(0, firstName, lastName, email, phone, address)
            contactViewModel.insertContact(capturedContact)
            Toast.makeText(context, "Saved contact",Toast.LENGTH_SHORT).show()

            this.findNavController().navigateUp()

        }

        return binding.root

    }


}
