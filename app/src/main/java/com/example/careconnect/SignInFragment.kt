package com.example.careconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.careconnect.databinding.SignInBinding

class SignInFragment : Fragment() {
    lateinit var binding: SignInBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInBinding.inflate(layoutInflater)
        binding.apply {
            btnProceedLogIn.setOnClickListener{
                val route = R.id.action_sign_in_to_view_child_details
                findNavController().navigate(route)
            }
        }
        return binding.root
    }
}
