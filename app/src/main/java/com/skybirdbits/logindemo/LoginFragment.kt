package com.skybirdbits.logindemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.skybirdbits.logindemo.databinding.FragmentLoginBinding
import kotlin.random.Random

class LoginFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater, container , false)

        
        val usernameInput = binding.usernameInput
        val passwordInput = binding.passwordInput


        binding.loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val id = Random(1000)

            println(id.nextInt())

            if(password.isNotBlank() && username.isNotBlank()) {
                Snackbar.make(binding.root, "Welcome $username" , Snackbar.LENGTH_SHORT).show()
                val action =
                    LoginFragmentDirections.fromLoginFragmentToProfileFragment(username, id.nextLong().toString())
                findNavController().navigate(action)
            }else {
                Toast.makeText(context , "Username and Password Should not be empty!", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }
}