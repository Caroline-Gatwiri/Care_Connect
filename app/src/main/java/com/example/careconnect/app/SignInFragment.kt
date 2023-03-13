package com.example.careconnect.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.careconnect.R
import com.example.careconnect.databinding.SignInBinding

class SignInFragment : Fragment() {
    lateinit var binding: SignInBinding

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
    }
}
