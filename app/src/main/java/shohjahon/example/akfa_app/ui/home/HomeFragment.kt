package shohjahon.example.akfa_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.note.ui.base.BaseFragment
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.databinding.FragmentHomeBinding

class HomeFragment :BaseFragment<FragmentHomeBinding>(){
    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding  = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}