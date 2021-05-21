package shohjahon.example.akfa_app.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.note.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import shohjahon.example.akfa_app.databinding.FragmentLoginBinding

@AndroidEntryPoint
class LoginFragment :BaseFragment<FragmentLoginBinding>() {
    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding  = FragmentLoginBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}