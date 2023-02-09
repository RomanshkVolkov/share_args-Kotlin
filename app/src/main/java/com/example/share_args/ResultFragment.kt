package com.example.share_args

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.share_args.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null

    private val binding get() = _binding!!
    private var name: String ? = ""
    private var lastName: String  = ""
    private var age : Int ? = 0
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = args.user.name
        lastName = args.user.lastname
        age = args.user.age
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("num1","a")
        Log.e("num2", "$name")
        _binding?.resultName?.text = "Nombre: ${name}"
        _binding?.resultLastname?.text = "Nombre: ${lastName}"
        _binding?.resultAge?.text = "Nombre: ${age}"

        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_formFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}