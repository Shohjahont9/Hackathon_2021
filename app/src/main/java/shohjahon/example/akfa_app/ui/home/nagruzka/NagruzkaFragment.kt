package shohjahon.example.akfa_app.ui.home.nagruzka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.note.ui.base.BaseFragment
import shohjahon.example.akfa_app.databinding.FragmentNagruzkaBinding


class NagruzkaFragment(fragment: Fragment) : BaseFragment<FragmentNagruzkaBinding>() {
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNagruzkaBinding = FragmentNagruzkaBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}