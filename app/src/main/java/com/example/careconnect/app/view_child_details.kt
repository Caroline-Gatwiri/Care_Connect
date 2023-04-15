package com.example.careconnect.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.careconnect.R
import com.example.careconnect.data.Child
import com.example.careconnect.databinding.FragmentViewChildDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewChildDetails : Fragment() {
    private lateinit var binding: FragmentViewChildDetailsBinding
    private val viewModel: ChildDetailsViewModel by viewModels<ChildDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewChildDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllChildren()

       val childDetailAdapter = ChildDetailAdapter()
        binding.recyclerView.apply {
            adapter = childDetailAdapter
        }

        viewModel.childResponse.observe(viewLifecycleOwner){Child ->
            if (Child.isNotEmpty()){
                childDetailAdapter.updateData(Child)
                childDetailAdapter.notifyDataSetChanged()
            }
        }
    }
   }