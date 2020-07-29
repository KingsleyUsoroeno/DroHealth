package com.techkingsley.drohealth.presentation.ui.authentication.sign_up

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.storage.SharedPreferenceStorage
import com.techkingsley.drohealth.databinding.FragmentSignUpBinding
import com.techkingsley.drohealth.presentation.ui.base.ViewModelFactory

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var viewBinding: FragmentSignUpBinding
    private lateinit var navController: NavController
    private val signUpViewModel: SignUpViewModel by viewModels {
        ViewModelFactory(this.requireActivity().application, SharedPreferenceStorage(requireContext()))
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        viewBinding = FragmentSignUpBinding.bind(requireView())
        viewBinding.signUpViewModel = signUpViewModel
        viewBinding.lifecycleOwner = this

        viewBinding.textLogin.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        signUpViewModel.loginState.observe(this.viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(this.requireContext(), "Please Sign in to confirm your credentials", Toast.LENGTH_LONG).show()
                navController.navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        })
    }
}