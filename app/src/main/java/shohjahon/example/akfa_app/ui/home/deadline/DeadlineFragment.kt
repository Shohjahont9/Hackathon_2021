package shohjahon.example.akfa_app.ui.home.deadline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.note.ui.base.BaseFragment
import shohjahon.example.akfa_app.databinding.FragmentDeadlineBinding

class DeadlineFragment(fragment: Fragment) : BaseFragment<FragmentDeadlineBinding>() {
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDeadlineBinding = FragmentDeadlineBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}