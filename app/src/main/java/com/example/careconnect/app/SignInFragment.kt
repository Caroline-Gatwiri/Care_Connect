package com.example.careconnect.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ericdev.validitychecker.ValidityChecker
import com.ericdev.validitychecker.ValidityChecker.Companion.isValidEmail
import com.example.careconnect.LogInState
import com.example.careconnect.LogInViewModel
import com.example.careconnect.R
import com.example.careconnect.databinding.SignInBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LogInFragment : Fragment() {
    private val viewModel: LogInViewModel by viewModels()
    private lateinit var binding: SignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.etLogInEmail.addTextChangedListener {
            val newText = binding.etLogInEmail.text.toString().trim()
            viewModel.inputEmail = newText
        }

        binding.etLogInPassword.addTextChangedListener {
            val newText = binding.etLogInPassword.text.toString().trim()
            viewModel.inputPassword = newText
        }

        binding.btnProceedLogIn.setOnClickListener { button ->
            val email = viewModel.inputEmail
            val password = viewModel.inputPassword

            if (isValidEmail(email) is ValidityChecker.Valid && password.isNotEmpty()) {
                viewModel.logInUser()
                viewModel.logInState.observe(viewLifecycleOwner) { state ->
                    when (state) {
                        LogInState.LOADING -> {
                            button.isEnabled = false
                            Toast.makeText(requireActivity(), "Loading...", Toast.LENGTH_SHORT)
                                .show()
                        }
                        LogInState.SUCCESSFUL -> {
                            Toast.makeText(requireActivity(), "Success!", Toast.LENGTH_SHORT).show()
                            viewModel.logInState.removeObservers(viewLifecycleOwner)

                            findNavController().navigate(R.id.action_sign_in_to_view_child_details)
                        }
                        LogInState.FAILED -> {
                            button.isEnabled = true
                            Toast.makeText(requireActivity(), "Failed!", Toast.LENGTH_SHORT)
                                .show()
                            viewModel.logInState.removeObservers(viewLifecycleOwner)
                        }
                        else -> {
                            button.isEnabled = true
                            viewModel.logInState.removeObservers(viewLifecycleOwner)
                        }
                    }
                }
            } else if (isValidEmail(email) is ValidityChecker.InValid) {
                binding.etLogInEmail.error = isValidEmail(email).message
            } else if (password.isEmpty()) {
                binding.etLogInPassword.error = "password is required"
            }
        }
    }

   /** lateinit var binding: SignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnProceedLogIn.setOnClickListener {

                // TODO: Validate inputs and 'SignIn State' before navigating
                val route = R.id.action_sign_in_to_view_child_details
                findNavController().navigate(route)
            }
        }
    }**/
}
