package com.polish.mycontact.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.polish.mycontact.R
import com.polish.mycontact.databinding.FragmentEditBinding
import com.polish.mycontact.model.Contact
import com.polish.mycontact.viewModel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_edit.*

/**
 * A simple [Fragment] subclass.
 */
class Edit : Fragment() {

    var contact:Contact? = null

    val args:ProfileArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_edit, container, false)

        val binding = FragmentEditBinding.inflate(inflater, container, false)
        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        // receiving the arguments and setting it to the xml
        contact = args.contact
        binding.contact = contact



        Log.i("OUTPUT", "$contact")

        binding.updateButtonId.setOnClickListener {

            contactViewModel.update(contact!!)
            this.findNavController().navigateUp()

        }


        return binding.root

    }




}
