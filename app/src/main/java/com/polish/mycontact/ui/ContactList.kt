package com.polish.mycontact.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.polish.mycontact.R
import com.polish.mycontact.adapter.ContactListAdapter
import com.polish.mycontact.databinding.FragmentContactListBinding
import com.polish.mycontact.model.Contact
import com.polish.mycontact.utils.OnItemClickListener
import com.polish.mycontact.viewModel.ContactViewModel

/**
 * A simple [Fragment] subclass.
 */
class ContactList : Fragment() {

    var contactlist:List<Contact> = ArrayList<Contact>()

    private lateinit var contactViewModel:ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_contact_list, container, false)

        val binding = FragmentContactListBinding.inflate(inflater, container, false)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val recyclerView = binding.recyclerview1

        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = ContactListAdapter(contactlist,
            object:OnItemClickListener{
                override fun OnItemClick(contact: Contact) {

                    val action =
                        ContactListDirections.actionContactListToProfile(contact)
                    findNavController().navigate(action)
                }
            },contactViewModel


        )
        recyclerView.adapter = adapter
//        contactViewModel.getAllContact().observe(viewLifecycleOwner, Observer<List<Contact>>{ contactlist
//            contactlist.let {
//                adapter.contactlist = contactlist
//                adapter.notifyDataSetChanged()
//            }
//        })


        contactViewModel.getAllContact().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.contactlist = it
                adapter.notifyDataSetChanged()
            }
        })




        binding.floatingActionButtonId.setOnClickListener {
            findNavController().navigate(R.id.action_contactList_to_addContact)
        }




        return binding.root
    }


}
