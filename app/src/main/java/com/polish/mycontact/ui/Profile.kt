package com.polish.mycontact.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.polish.mycontact.R
import com.polish.mycontact.databinding.FragmentProfileBinding
import com.polish.mycontact.model.Contact

/**
 * A simple [Fragment] subclass.
 */
class Profile : Fragment() {

   val args:ProfileArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)

        val binding = FragmentProfileBinding.inflate(inflater, container, false)


        binding.contact = args.contact

        return binding.root

    }


}
