package com.polish.mycontact.ui


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.polish.mycontact.R
import com.polish.mycontact.databinding.FragmentProfileBinding
import com.polish.mycontact.model.Contact
import com.polish.mycontact.viewModel.ContactViewModel

/**
 * A simple [Fragment] subclass.
 */
class Profile : Fragment() {

    var contactViewModel:ContactViewModel? = null
    var contact:Contact? = null

   val args:ProfileArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)

        val binding = FragmentProfileBinding.inflate(inflater, container, false)
         contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)


        contact = args.contact
        binding.contact = contact
        // enable option menu
        setHasOptionsMenu(true)

        return binding.root

    }

    // inflate the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.edit_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // get item id to handle item clicks

        val id = item.itemId
        // handle item clicks
        if(id == R.id.edit){
            val action =
                ProfileDirections.actionProfileToEdit3(contact!!)
            findNavController().navigate(action)
            Toast.makeText(context, "Edit Contact", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.delete){
            val mAlertDialog = AlertDialog.Builder(context!!)
            mAlertDialog.setTitle("Delete Contact")
            mAlertDialog.setMessage("Delete contact permanently...")
            mAlertDialog.setIcon(R.mipmap.ic_launcher)
            // add a positive button to alert dialogue
            mAlertDialog.setPositiveButton("Delete"){
                dialog,id ->
                contactViewModel?.delete(contact!!)
                Toast.makeText(context, "Contact deleted", Toast.LENGTH_SHORT).show()
                this.findNavController().navigateUp()
            }
            // add a negative button to alert dialogue
            mAlertDialog.setNegativeButton("Cancel"){dialog, id ->
                dialog.dismiss()
            }
            mAlertDialog.show()
        }
        return super.onOptionsItemSelected(item)
    }


}
