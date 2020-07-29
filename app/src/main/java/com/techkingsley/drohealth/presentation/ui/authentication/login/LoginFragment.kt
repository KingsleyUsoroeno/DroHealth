package com.techkingsley.drohealth.presentation.ui.authentication.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.data.local.storage.SharedPreferenceStorage
import com.techkingsley.drohealth.databinding.FragmentLoginBinding
import com.techkingsley.drohealth.presentation.ui.base.ViewModelFactory


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var viewBinding: FragmentLoginBinding
    private lateinit var navController: NavController
    private val loginViewModel: LoginViewModel by viewModels {
        ViewModelFactory(this.requireActivity().application, SharedPreferenceStorage(requireContext()))
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentLoginBinding.bind(requireView())
        viewBinding.loginViewModel = loginViewModel
        viewBinding.lifecycleOwner = this
        navController = NavHostFragment.findNavController(this)

        viewBinding.textSignUp.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        loginViewModel.loginState.observe(this.viewLifecycleOwner, Observer {
            if(it){
                navController.navigate(R.id.action_loginFragment_to_homeActivity)
                requireActivity().finish()
            }
        })
    }
}