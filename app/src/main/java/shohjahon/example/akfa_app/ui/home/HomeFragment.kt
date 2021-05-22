package shohjahon.example.akfa_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.note.ui.base.BaseFragment
import com.example.note.ui.utils.nextPageMain
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.adapter.ViewPagerAdapter
import shohjahon.example.akfa_app.databinding.FragmentHomeBinding
import shohjahon.example.akfa_app.ui.persons.PersonsFragment

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(){

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding  = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()

        onClicks()

    }

    private fun onClicks() {
        ll_stanok.setOnClickListener{
            nextPageMain(PersonsFragment(), "gg->Person")
        }
    }


    private fun setViewPager() {
        with(binding!!) {
            viewPager.adapter = ViewPagerAdapter(this@HomeFragment)
            viewPager.isUserInputEnabled = true
            val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Muddati yaqin"
                    1 -> tab.text = "Nagruzka"
                }
            }
            tabLayoutMediator.attach()
        }
    }
}