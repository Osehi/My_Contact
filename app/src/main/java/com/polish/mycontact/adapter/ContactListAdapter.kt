package com.polish.mycontact.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycontact.databinding.SingleContactItemBinding
import com.polish.mycontact.model.Contact
import com.polish.mycontact.utils.OnItemClickListener
import com.polish.mycontact.viewModel.ContactViewModel

class ContactListAdapter(var contactlist:List<Contact>, val onItemClickListener: OnItemClickListener, val contactViewModel: ContactViewModel):
    RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleContactItemBinding.inflate(inflater, parent,false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactlist.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        var contact = contactlist[position]
        holder.bind(contact, onItemClickListener)
    }


    class ContactViewHolder(var binding:SingleContactItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(contact:Contact, onItemClickListener:OnItemClickListener){
            binding.contact = contact
            binding.root.setOnClickListener {
                onItemClickListener.OnItemClick(contact)
            }
            binding.executePendingBindings()
        }

    }



}