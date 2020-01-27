package com.polish.mycontact.ui


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.polish.mycontact.R
import com.polish.mycontact.databinding.FragmentProfileBinding
import com.polish.mycontact.model.Contact

/**
 * A simple [Fragment] subclass.
 */
class Profile : Fragment() {

    var contact:Contact? = null

   val args:ProfileArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)

        val binding = FragmentProfileBinding.inflate(inflater, container, false)


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
        return super.onOptionsItemSelected(item)
    }


}
