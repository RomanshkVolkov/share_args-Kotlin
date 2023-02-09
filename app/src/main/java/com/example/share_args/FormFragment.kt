package com.example.share_args

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.share_args.databinding.FragmentFormBinding
import com.example.share_args.model.User
import java.util.regex.Matcher
import java.util.regex.Pattern
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FormFragment : Fragment() {
    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnJoin.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val lastName = binding.lastname.text.toString().trim()
            val age = binding.age.text.toString().trim()

            if (isNameValid(name) && isLastNameValid(lastName) && isAgeValid(age)) {
                val user = User(name = name, lastname = lastName, age = age.toInt())
                val action = FormFragmentDirections.actionFormFragmentToResultFragment(user)
                findNavController().navigate(action)
                Log.e("tag", "$user")
            } else {
                Toast.makeText(
                    requireContext(),
                    "Por favor verifique los datos ingresados.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isNameValid(name: String): Boolean {
        val nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
        val pattern = Pattern.compile(nameRegex)
        val matcher = pattern.matcher(name)
        return matcher.matches()
    }

    private fun isLastNameValid(lastName: String): Boolean {
        val lastNameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
        val pattern = Pattern.compile(lastNameRegex)
        val matcher = pattern.matcher(lastName)
        return matcher.matches()
    }

    private fun isAgeValid(age: String): Boolean {
        val ageRegex = "^[0-9]{1,2}$"
        val pattern = Regex(ageRegex)
        return pattern.matches(age)
    }
}
