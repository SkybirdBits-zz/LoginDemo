package com.skybirdbits.logindemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.skybirdbits.logindemo.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)

        val username = requireArguments().getString("usrname")
        val id = requireArguments().getString("id")

        binding.username = username
        binding.userId = id


        binding.logoutButton.setOnClickListener {
            val action = ProfileFragmentDirections.fromProfileFragmentToLoginFragment()
            findNavController().navigate(action)
            Snackbar.make(binding.root,"You've been logged out", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }
}