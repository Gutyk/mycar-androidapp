package com.br.guty.mycar.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.br.guty.mycar.R


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private var isLoginMode = true
    override fun onCreateView (
        inflater: LayoutInflater , container: ViewGroup ?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container,
            false)
        setupUI()
        setUpListeners()
        return binding.root
    }
    private fun setUpListeners () {
        binding.tvSwitchMode .setOnClickListener {
            isLoginMode = !isLoginMode
            setupUI()
        }
        binding.btnAuth.setOnClickListener {
            val action =
                LoginFragmentDirections.actionLoginFragmentToCarFragment()
            findNavController().navigate(action)
        }
    }
    private fun setupUI() {
        if (isLoginMode ) {
            binding.btnAuth.text = "Login"
            binding.tvSwitchMode.text = "Don't have an account? Sign Up"
        } else {
            binding.btnAuth.text = "Sign Up"
            binding.tvSwitchMode.text = "Already have an account? Login"
        }
    }
}